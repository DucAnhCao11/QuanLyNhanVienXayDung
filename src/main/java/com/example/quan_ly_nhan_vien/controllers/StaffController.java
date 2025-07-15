package com.example.quan_ly_nhan_vien.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.CreateStaffRequest;
import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.StaffUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.ApiResponse;
import com.example.quan_ly_nhan_vien.dto.responses.StaffResponse;
import com.example.quan_ly_nhan_vien.services.interfaces.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private static final Logger log = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    @GetMapping
    public ApiResponse<List<StaffResponse>> getAll() {
        return ApiResponse.<List<StaffResponse>>builder()
                .message("Danh sách nhân viên:")
                .result(staffService.getAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<StaffResponse> getById(@PathVariable Long id) {
        return ApiResponse.<StaffResponse>builder()
                .message("Đã tìm thấy nhân viên")
                .result(staffService.getById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<StaffResponse> staffCreation(@Valid @RequestBody CreateStaffRequest request) {
        return ApiResponse.<StaffResponse>builder()
                .message("Đã tạo nhân viên thành công")
                .result(staffService.staffCreation(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<StaffResponse> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        return ApiResponse.<StaffResponse>builder()
                .message("Đã cập nhật thành công")
                .result(staffService.updateStaff(request, id))
                .build();
    }
}
