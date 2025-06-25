package com.example.quan_ly_nhan_vien.dto.requests.userRequest;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationRequest {
    private Integer idRole;

    @NotBlank(message = "EMAIL_NOT_BLANK")
    @Email(message = "EMAIL_ERROR")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=.*[a-zA-Z]).{8,}$", message = "PASSWORD_ERROR")
    private String matKhau;

    private LocalDate ngayTao = LocalDate.now();

    private Integer trangThai = 1;
}
