package com.example.quan_ly_nhan_vien.services.interfaces;

import com.example.quan_ly_nhan_vien.dto.requests.authRequest.AuthenticationRequest;
import com.example.quan_ly_nhan_vien.dto.requests.authRequest.IntrospectRequest;
import com.example.quan_ly_nhan_vien.dto.responses.AuthenticationResponse;
import com.example.quan_ly_nhan_vien.dto.responses.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
