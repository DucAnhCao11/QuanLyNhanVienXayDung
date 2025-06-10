package com.example.quan_ly_nhan_vien.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RoleErrorCode implements BaseErrorCode {
    ROLE_NOT_FOUND(2001,"Role not found", HttpStatus.NOT_FOUND),
    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
