package com.example.quan_ly_nhan_vien.services.interfaces;

import com.example.quan_ly_nhan_vien.dto.requests.authRequest.AuthenticationRequest;

public interface AuthenticationService {
    boolean authenticate(AuthenticationRequest authenticationRequest);
}
