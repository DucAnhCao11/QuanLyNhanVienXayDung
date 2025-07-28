package com.example.quan_ly_nhan_vien.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ValidateError implements BaseErrorCode {
    EMAIL_ERROR(1003, "Invalid email format", HttpStatus.BAD_REQUEST),
    EMAIL_NOT_BLANK(1004, "Email must not be blank ", HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(
            1005,
            "Password must start with a capital letter and must contain special characters "
                    + "and Username must be least 5 characters",
            HttpStatus.BAD_REQUEST),
    NAME_NOT_EMPTY(1007, "Name is empty", HttpStatus.BAD_REQUEST),
    INVALID_NAME_LENGTH(1008, "The name must be at least 10 characters long.", HttpStatus.BAD_REQUEST),
    INVALID_DOB(1009, "You must be at least 18 years old", HttpStatus.BAD_REQUEST),
    IMAGE_ERROR(1010, "Invalid image format", HttpStatus.BAD_REQUEST),
    GENDER_ERROR(1011, "Invalid gender", HttpStatus.BAD_REQUEST),
    CCCD_ERROR(1012, "Citizen ID must be at least 12 characters", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_ERROR(1013, "The number phone must be at least 10 characters", HttpStatus.BAD_REQUEST),
    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
