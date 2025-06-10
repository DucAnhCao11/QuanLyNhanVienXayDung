package com.example.quan_ly_nhan_vien.dto.requests.authRequest;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {
    private String email;
    private String matKhau;
}
