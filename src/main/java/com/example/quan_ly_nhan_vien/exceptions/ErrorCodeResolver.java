package com.example.quan_ly_nhan_vien.exceptions;

import java.util.List;

public class ErrorCodeResolver {

    private static final List<Class<? extends Enum<?>>> errorEnums = List.of(
            UserErrorCode.class,
            CommonErrorCode.class
    );

    @SuppressWarnings("unchecked")
    public static BaseErrorCode resolve(String key) {
        for (Class<? extends Enum<?>> clazz : errorEnums) {
            try {
                Enum<?> enumVal = Enum.valueOf((Class<? extends Enum>) clazz, key);
                if (enumVal instanceof BaseErrorCode) {
                    return (BaseErrorCode) enumVal;
                }
            } catch (IllegalArgumentException ignored) {
                // Không tìm thấy enum trong class này, tiếp tục.
            }
        }
        return CommonErrorCode.ENUM_INVALID_KEY;
    }
}
