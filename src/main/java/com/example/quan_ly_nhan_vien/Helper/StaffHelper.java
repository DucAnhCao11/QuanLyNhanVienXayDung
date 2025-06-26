package com.example.quan_ly_nhan_vien.Helper;

import java.util.Random;

public class StaffHelper {
    private static final String PREFIX = "NV";
    private static final int MAX_CODE = 1_000_000;
    private static final Random RANDOM = new Random();

    public static String generateStaffCode() {
        int number = RANDOM.nextInt(MAX_CODE);
        return PREFIX + String.format("%06d", number);
    }

}
