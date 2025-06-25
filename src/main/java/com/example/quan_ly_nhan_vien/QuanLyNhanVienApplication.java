package com.example.quan_ly_nhan_vien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuanLyNhanVienApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanLyNhanVienApplication.class, args);
    }
}
