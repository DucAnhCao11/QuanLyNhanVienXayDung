package com.example.quan_ly_nhan_vien.configurations;

import com.example.quan_ly_nhan_vien.dto.responses.ApiResponse;
import com.example.quan_ly_nhan_vien.exceptions.AppException;
import com.example.quan_ly_nhan_vien.exceptions.AuthErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        AppException ex = new AppException(AuthErrorCode.UNAUTHORIZED);
        ApiResponse body = new ApiResponse();
        body.setCode(ex.getErrorCode().getCode());
        body.setMessage(ex.getErrorCode().getMessage());

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(body));
    }
}
