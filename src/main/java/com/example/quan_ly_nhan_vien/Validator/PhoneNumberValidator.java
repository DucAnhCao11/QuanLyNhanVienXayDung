package com.example.quan_ly_nhan_vien.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {
    private int min;

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(string))
            return true;

        int size = string.length();

        return size >= min;
    }

    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }
}
