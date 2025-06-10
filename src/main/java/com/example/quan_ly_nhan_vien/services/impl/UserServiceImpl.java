package com.example.quan_ly_nhan_vien.services.impl;

import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserCreationRequest;
import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.UserResponse;
import com.example.quan_ly_nhan_vien.entities.Role;
import com.example.quan_ly_nhan_vien.entities.User;
import com.example.quan_ly_nhan_vien.exceptions.AppException;
import com.example.quan_ly_nhan_vien.exceptions.RoleErrorCode;
import com.example.quan_ly_nhan_vien.exceptions.UserErrorCode;
import com.example.quan_ly_nhan_vien.mappers.UserMapper;
import com.example.quan_ly_nhan_vien.repositories.RoleRepository;
import com.example.quan_ly_nhan_vien.repositories.UserRepository;
import com.example.quan_ly_nhan_vien.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getUserById(Long id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(UserErrorCode.USER_NOT_FOUND)));
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        Role role = roleRepository.findById(request.getIdRole())
                .orElseThrow(() -> new AppException(RoleErrorCode.ROLE_NOT_FOUND));

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(UserErrorCode.EMAIL_ALREADY_EXISTS);
        }

        User user = userMapper.toUser(request);
        user.setMatKhau(passwordEncoder.encode(user.getMatKhau()));
        user.setRole(role);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        Role role = roleRepository.findById(request.getIdRole())
                .orElseThrow(() -> new AppException(RoleErrorCode.ROLE_NOT_FOUND));

        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(UserErrorCode.USER_NOT_FOUND));

        userMapper.updateUser(user, request);
        user.setMatKhau(passwordEncoder.encode(user.getMatKhau()));
        user.setRole(role);

        return userMapper.toUserResponse(userRepository.save(user));
    }
}
