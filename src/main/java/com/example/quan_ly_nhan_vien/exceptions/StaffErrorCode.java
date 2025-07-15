package com.example.quan_ly_nhan_vien.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StaffErrorCode implements BaseErrorCode {
    STAFF_NOT_FOUND(1001, "Staff not found", HttpStatus.NOT_FOUND),
    STAFF_CODE_ALREADY_EXISTS(1002, "Staff code already exists", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS(1003, "Email already exists", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_ALREADY_EXISTS(1004, "Phone number already exists", HttpStatus.BAD_REQUEST),
    CCCD_ALREADY_EXISTS(1005, "Citizen ID  already exists", HttpStatus.BAD_REQUEST),
    INVALID_DOB(1006, "You must be at least 18 years old", HttpStatus.BAD_REQUEST),
    ;

    private final int code;
    private final String message;
    private final HttpStatus httpStatusCode;
}
