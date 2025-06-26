package com.example.quan_ly_nhan_vien.services.interfaces;

import java.util.List;

import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.CreateStaffRequest;
import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.StaffUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.StaffResponse;

public interface StaffService {
    List<StaffResponse> getAll();

    StaffResponse getById(Long id);

    StaffResponse staffCreation(CreateStaffRequest request);

    StaffResponse updateStaff(StaffUpdateRequest request, Long id);
}
