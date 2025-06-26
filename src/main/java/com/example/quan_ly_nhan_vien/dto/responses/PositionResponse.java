package com.example.quan_ly_nhan_vien.dto.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PositionResponse {
    String maChucVu;

    String tenChucVu;
}
