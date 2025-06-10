package com.example.quan_ly_nhan_vien.dto.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;

    private Object role;

    private String email;

    private String ngayTao;

    private Integer trangThai;
}
