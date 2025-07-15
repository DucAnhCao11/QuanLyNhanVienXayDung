package com.example.quan_ly_nhan_vien.dto.requests.StaffRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffUpdateRequest {
    private Integer idChucVu;

    private String hinhAnh;

    private LocalDate ngaySinh;

    private String soCCCD;

    private String soDienThoai;

    private String email;

    private String diaChi;

    private BigDecimal luongCoBan;

    private Double heSoLuong;

    private LocalDate ngayNghiViec;

    private String trangThai;
}
