package com.example.quan_ly_nhan_vien.controllers;

import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserCreationRequest;
import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.ApiResponse;
import com.example.quan_ly_nhan_vien.dto.responses.UserResponse;
import com.example.quan_ly_nhan_vien.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUser() {
        return ApiResponse.<List<UserResponse>>builder()
                .message("Danh sách user:")
                .result(userService.getAllUser())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable long id) {
        return ApiResponse.<UserResponse>builder()
                .message("Đã lấy được user với id: " + id)
                .result(userService.getUserById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<UserResponse>builder()
                .message("Đã thêm mới một user.")
                .result(userService.createUser(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable long id, @RequestBody @Valid UserUpdateRequest request) {
        return  ApiResponse.<UserResponse>builder()
                .message("Đã cập nhật User với id:" + id)
                .result(userService.updateUser(id, request))
                .build();
    }
}
