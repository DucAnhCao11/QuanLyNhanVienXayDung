package com.example.quan_ly_nhan_vien.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorCodeResolver {

    private static final Map<String, BaseErrorCode> ERROR_CODE_MAP = new HashMap<>();

    static {
        List<Class<? extends Enum<?>>> errorEnums = List.of(
                UserErrorCode.class,
                StaffErrorCode.class,
                CommonErrorCode.class
        );

        for (Class<? extends Enum<?>> clazz : errorEnums) {
            for (Enum<?> constant : clazz.getEnumConstants()) {
                if (constant instanceof BaseErrorCode code) {
                    String key = constant.name();

                    if (ERROR_CODE_MAP.containsKey(key)) {
                        System.err.println(" Duplicate error code key: " + key);
                    }

                    ERROR_CODE_MAP.put(key, code);
                }
            }
        }
    }

    public static BaseErrorCode resolve(String key) {
        return ERROR_CODE_MAP.getOrDefault(key, CommonErrorCode.ENUM_INVALID_KEY);
    }

    public static boolean exists(String key) {
        return ERROR_CODE_MAP.containsKey(key);
    }
}
