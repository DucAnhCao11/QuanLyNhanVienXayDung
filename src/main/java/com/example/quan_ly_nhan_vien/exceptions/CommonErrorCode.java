package com.example.quan_ly_nhan_vien.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonErrorCode implements BaseErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    ENUM_INVALID_KEY(9001, "Enum invalid key", HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatus HttpStatusCode;
}
