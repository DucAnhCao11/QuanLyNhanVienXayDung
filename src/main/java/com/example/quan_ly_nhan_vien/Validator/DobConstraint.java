package com.example.quan_ly_nhan_vien.Validator;

@java.lang.annotation.Target({ java.lang.annotation.ElementType.FIELD })
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = {DobValidator.class})
public @interface DobConstraint {
    java.lang.String message() default "INVALID_DOB";

    int min();

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends jakarta.validation.Payload>[] payload() default {};
}
