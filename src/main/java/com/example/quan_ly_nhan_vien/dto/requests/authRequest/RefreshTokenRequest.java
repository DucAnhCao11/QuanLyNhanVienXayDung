package com.example.quan_ly_nhan_vien.dto.requests.authRequest;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshTokenRequest {
    private String token;
}
