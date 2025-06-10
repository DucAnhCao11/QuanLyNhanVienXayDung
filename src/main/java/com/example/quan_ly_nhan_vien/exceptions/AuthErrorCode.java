package com.example.quan_ly_nhan_vien.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements BaseErrorCode{
    UNAUTHENTICATED(1401,"Unauthenticated", HttpStatus.UNAUTHORIZED ),
    UNAUTHORIZED(1403,"You do not have permission.", HttpStatus.FORBIDDEN ),
    ;
    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
