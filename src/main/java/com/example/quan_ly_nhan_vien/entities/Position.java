package com.example.quan_ly_nhan_vien.entities;

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
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_chuc_vu")
    private String maChucVu;

    @Column(name = "ten_chuc_vu")
    private String tenChucVu;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
