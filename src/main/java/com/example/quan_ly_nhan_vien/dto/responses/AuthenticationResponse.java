package com.example.quan_ly_nhan_vien.dto.responses;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
}
