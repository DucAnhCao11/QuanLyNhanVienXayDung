package com.example.quan_ly_nhan_vien.dto.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponse {
    private String maRole;

    private String tenRole;
}
