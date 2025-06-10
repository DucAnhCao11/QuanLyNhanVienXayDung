package com.example.quan_ly_nhan_vien.services.impl;

import com.example.quan_ly_nhan_vien.dto.requests.authRequest.AuthenticationRequest;
import com.example.quan_ly_nhan_vien.exceptions.AppException;
import com.example.quan_ly_nhan_vien.exceptions.UserErrorCode;
import com.example.quan_ly_nhan_vien.repositories.UserRepository;
import com.example.quan_ly_nhan_vien.services.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean authenticate(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new AppException(UserErrorCode.EMAIL_NOT_EXISTS));
        boolean authenticate = passwordEncoder.matches(authenticationRequest.getMatKhau(), user.getMatKhau());
        if(!authenticate)
            throw new AppException(UserErrorCode.PASSWORD_NOT_MATCH);

        return passwordEncoder.matches(authenticationRequest.getMatKhau(), user.getMatKhau());
    }
}
