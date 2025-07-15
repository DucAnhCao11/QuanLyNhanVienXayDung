package com.example.quan_ly_nhan_vien.dto.requests.StaffRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.quan_ly_nhan_vien.Validator.DobConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStaffRequest {
    private Integer idChucVu;

    private String hoTen;

    private String hinhAnh;

    private Integer gioiTinh;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    private LocalDate ngaySinh;

    private String soCCCD;

    private String soDienThoai;

    private String email;

    private String diaChi;

    private BigDecimal luongCoBan;

    private Double heSoLuong;

    private LocalDate ngayVaoLam;

    private LocalDate ngayNghiViec;

    private String trangThai;
}
