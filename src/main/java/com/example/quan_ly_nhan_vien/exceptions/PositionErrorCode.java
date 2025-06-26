package com.example.quan_ly_nhan_vien.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PositionErrorCode implements BaseErrorCode {
    POSITION_NOT_FOUND(1001, "Position not found", HttpStatus.NOT_FOUND),
    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
