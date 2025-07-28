package com.example.quan_ly_nhan_vien.dto.responses;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;

    private RoleResponse role;

    private String email;

    private LocalDate ngayTao;

    private Integer trangThai;
}
