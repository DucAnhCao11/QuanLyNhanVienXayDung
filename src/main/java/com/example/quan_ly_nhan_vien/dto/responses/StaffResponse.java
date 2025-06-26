package com.example.quan_ly_nhan_vien.dto.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StaffResponse {
    Long id;

    PositionResponse positionResponse;

    UserResponse userResponse;

    String maNhanVien;

    String hoTen;

    String hinhAnh;

    Integer gioiTinh;

    String ngaySinh;

    String soCCCD;

    String soDienThoai;

    String email;

    String diaChi;

    BigDecimal luongCoBan;

    Double heSoLuong;

    LocalDate ngayVaoLam;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDate ngayNghiViec;

    String trangThai;
}
