package com.example.quan_ly_nhan_vien.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quan_ly_nhan_vien.entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    boolean existsByEmail(String email);

    boolean existsBySoDienThoai(String soDienThoai);

    boolean existsBySoCCCD(String soCCCD);

    boolean existsByMaNhanVien(String maNhanVien);

    Optional<Staff> findByEmail(String email);

    Optional<Staff> findBySoDienThoai(String soDienThoai);

    Optional<Staff> findBySoCCCD(String soCCCD);
}
