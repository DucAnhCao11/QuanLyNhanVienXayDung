package com.example.quan_ly_nhan_vien.services.interfaces;

import java.util.List;

import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserCreationRequest;
import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.UserResponse;

public interface UserService {
    UserResponse getUserById(Long id);

    List<UserResponse> getAllUser();

    UserResponse createUser(UserCreationRequest request);

    UserResponse updateUser(Long id, UserUpdateRequest request);

    UserResponse getMyInfo();
}
