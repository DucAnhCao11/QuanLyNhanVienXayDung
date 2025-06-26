package com.example.quan_ly_nhan_vien.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quan_ly_nhan_vien.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {}
