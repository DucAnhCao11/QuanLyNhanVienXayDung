package com.example.quan_ly_nhan_vien.dto.requests.StaffRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.quan_ly_nhan_vien.Validator.DobConstraint;
import com.example.quan_ly_nhan_vien.Validator.PhoneNumberConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStaffRequest {
    private Integer idChucVu;

    @NotBlank(message = "NAME_NOT_EMPTY")
    @Size(min = 10, message = "INVALID_NAME_LENGTH")
    private String hoTen;

    @NotBlank(message = "IMAGE_ERROR")
    private String hinhAnh;

    @NotNull(message = "GENDER_ERROR")
    private Integer gioiTinh;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    private LocalDate ngaySinh;

    @Size(min = 12, message = "CCCD_ERROR")
    private String soCCCD;

    @PhoneNumberConstraint(min = 10, message = "PHONE_NUMBER_ERROR")
    private String soDienThoai;

    private String email;

    private String diaChi;

    private BigDecimal luongCoBan;

    private Double heSoLuong;

    private LocalDate ngayVaoLam;

    private LocalDate ngayNghiViec;

    private String trangThai;
}
