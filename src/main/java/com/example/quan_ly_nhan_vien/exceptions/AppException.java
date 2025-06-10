package com.example.quan_ly_nhan_vien.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
    private final BaseErrorCode errorCode;

    public AppException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public BaseErrorCode getErrorCode() {
        return errorCode;
    }
}
