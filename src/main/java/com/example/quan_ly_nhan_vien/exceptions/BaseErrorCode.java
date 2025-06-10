package com.example.quan_ly_nhan_vien.exceptions;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    int getCode();
    String getMessage();
    HttpStatus getHttpStatusCode();
}
