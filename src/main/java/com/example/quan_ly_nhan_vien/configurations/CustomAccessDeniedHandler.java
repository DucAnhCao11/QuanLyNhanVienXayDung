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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        AppException ex = new AppException(AuthErrorCode.FORBIDDEN);
        ApiResponse body = new ApiResponse();
        body.setCode(ex.getErrorCode().getCode());
        body.setMessage(ex.getErrorCode().getMessage());

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(body));
    }
}
