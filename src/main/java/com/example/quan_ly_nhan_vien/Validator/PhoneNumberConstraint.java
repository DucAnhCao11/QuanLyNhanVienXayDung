package com.example.quan_ly_nhan_vien.Validator;

@java.lang.annotation.Target({ java.lang.annotation.ElementType.FIELD })
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = {PhoneNumberValidator.class})
public @interface PhoneNumberConstraint {
    String message() default "Yoy must at be 12 characters only";

    int min();

    Class<?>[] groups() default {};

    Class<? extends jakarta.validation.Payload>[] payload() default {};
}
