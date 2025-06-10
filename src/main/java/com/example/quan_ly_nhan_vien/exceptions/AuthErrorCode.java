package com.example.quan_ly_nhan_vien.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements BaseErrorCode{
    UNAUTHORIZED(1401,"Unauthorized - Token is missing or invalid.", HttpStatus.UNAUTHORIZED ),
    FORBIDDEN(1403,"Forbidden - Token is invalid.", HttpStatus.FORBIDDEN ),
    ;
    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
