package com.example.quan_ly_nhan_vien.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {
    USER_NOT_FOUND(1001, "User not found", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_EXISTS(1002, "Email already exists", HttpStatus.CONFLICT),
    EMAIL_ERROR(1003, "Invalid email format", HttpStatus.BAD_REQUEST),
    EMAIL_NOT_BLANK(1004, "Email must not be blank ", HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(
            1005,
            "Password must start with a capital letter and must contain special characters "
                    + "and Username must be least 5 characters",
            HttpStatus.BAD_REQUEST),
    EMAIL_NOT_EXISTS(1006, "Email does not exist", HttpStatus.NOT_FOUND),
    PASSWORD_NOT_MATCH(1007, "Password does not match", HttpStatus.BAD_REQUEST),
    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
