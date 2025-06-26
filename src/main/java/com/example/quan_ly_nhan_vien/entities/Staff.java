package com.example.quan_ly_nhan_vien.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu", referencedColumnName = "id")
    private Position position;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @Column(name = "ma_nhan_vien", unique = true)
    private String maNhanVien;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "gioi_tinh")
    private Integer gioiTinh;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "so_CCCD", unique = true)
    private String soCCCD;

    @Column(name = "so_dien_thoai", unique = true)
    private String soDienThoai;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "luong_co_ban")
    private BigDecimal luongCoBan;

    @Column(name = "he_so_luong")
    private Double heSoLuong;

    @Column(name = "ngay_vao_lam")
    private LocalDate ngayVaoLam;

    @Column(name = "ngay_nghi_viec")
    private LocalDate ngayNghiViec;

    @Column(name = "trang_thai")
    private String trangThai;
}
