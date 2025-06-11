package com.example.quan_ly_nhan_vien.services.impl;

import com.example.quan_ly_nhan_vien.dto.requests.authRequest.AuthenticationRequest;
import com.example.quan_ly_nhan_vien.dto.requests.authRequest.IntrospectRequest;
import com.example.quan_ly_nhan_vien.dto.requests.authRequest.LogOutRequest;
import com.example.quan_ly_nhan_vien.dto.responses.ApiResponse;
import com.example.quan_ly_nhan_vien.dto.responses.AuthenticationResponse;
import com.example.quan_ly_nhan_vien.dto.responses.IntrospectResponse;
import com.example.quan_ly_nhan_vien.entities.InvalidatedToken;
import com.example.quan_ly_nhan_vien.entities.User;
import com.example.quan_ly_nhan_vien.exceptions.AppException;
import com.example.quan_ly_nhan_vien.exceptions.AuthErrorCode;
import com.example.quan_ly_nhan_vien.exceptions.UserErrorCode;
import com.example.quan_ly_nhan_vien.repositories.InvalidatedTokenRepository;
import com.example.quan_ly_nhan_vien.repositories.UserRepository;
import com.example.quan_ly_nhan_vien.services.interfaces.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    InvalidatedTokenRepository invalidatedTokenRepository;


    @Value("${jwt.signKey}")
    private String signKey;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new AppException(UserErrorCode.EMAIL_NOT_EXISTS));
        boolean authenticate = passwordEncoder.matches(authenticationRequest.getMatKhau(), user.getMatKhau());

        if(!authenticate)
            throw new AppException(UserErrorCode.PASSWORD_NOT_MATCH);
        var token = generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .build();

    }
    // Tạo ra ột token khi đăng nhập
    public String generateToken(User user) {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getEmail())
                .issuer("https://quan-ly-nhan-vien")
                .issueTime( new Date() )
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", user.getRole().getMaRole())
                .build();

        Payload payload = new Payload( jwtClaimsSet.toJSONObject() );
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(signKey.getBytes()));
            return jwsObject.serialize();
        }catch (JOSEException e) {
            log.error("Cannot sign JWT", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        String token = request.getToken();
        Boolean isValid = true;
        try {
            verifyToken(token);
        }catch (AppException e) {
            isValid = false;
        }

        return IntrospectResponse.builder()
                .valid(isValid)
                .build();
    }

    @Override
    public void logOut(LogOutRequest request) throws ParseException, JOSEException {
        var signToken = verifyToken(request.getToken());

        String jit = signToken.getJWTClaimsSet().getJWTID();
        Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jit)
                .expiryTime(expiryTime)
                .build();
        invalidatedTokenRepository.save(invalidatedToken);
    }

    private SignedJWT verifyToken (String token) throws JOSEException, ParseException {
        // Kiểm tra chữ ký của JWT
        JWSVerifier jwsVerifier = new MACVerifier(signKey.getBytes());

        // Phân tích (parse) token từ chuỗi JWT (token) để lấy thông tin bên trong
        SignedJWT signedJWT = SignedJWT.parse(token);

        // Lấy thời gian hết hạn của token từ claim
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        // Kiểm tra xem chữ kí token có hợp lệ không
        var verified = signedJWT.verify(jwsVerifier);

        if(!verified && expiryTime.after(new Date()))
            throw new AppException(AuthErrorCode.UNAUTHENTICATED);

        if(invalidatedTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID()))
            throw new AppException(AuthErrorCode.UNAUTHENTICATED);


        return signedJWT;
    }
}
