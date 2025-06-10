package com.example.quan_ly_nhan_vien.controllers;

import com.example.quan_ly_nhan_vien.dto.requests.authRequest.AuthenticationRequest;
import com.example.quan_ly_nhan_vien.dto.responses.ApiResponse;
import com.example.quan_ly_nhan_vien.dto.responses.AuthenticationResponse;
import com.example.quan_ly_nhan_vien.services.interfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        var result = authenticationService.authenticate(authenticationRequest);
        return ApiResponse.<AuthenticationResponse>builder()
                .message("Đăng nhập thành công.")
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
