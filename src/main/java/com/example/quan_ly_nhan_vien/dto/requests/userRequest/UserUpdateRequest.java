package com.example.quan_ly_nhan_vien.dto.requests.userRequest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequest {
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=.*[a-zA-Z]).{8,}$", message = "PASSWORD_ERROR")
    private String matKhau;

    private Integer idRole;

    @Min(value = 0, message = "STATUS_INVALID")
    @Max(value = 1, message = "STATUS_INVALID")
    private Integer trangThai;
}
