package com.example.quan_ly_nhan_vien.dto.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private boolean authenticated;
}
