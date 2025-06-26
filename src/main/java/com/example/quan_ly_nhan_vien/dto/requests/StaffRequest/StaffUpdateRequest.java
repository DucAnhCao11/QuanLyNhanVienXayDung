package com.example.quan_ly_nhan_vien.dto.requests.StaffRequest;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffUpdateRequest {
    private Integer idChucVu;

    private String hinhAnh;

    private String ngaySinh;

    private String soCCCD;

    private String soDienThoai;

    private String email;

    private String diaChi;

    private BigDecimal luongCoBan;

    private Double heSoLuong;

    private LocalDate ngayNghiViec;

    private String trangThai;
}
