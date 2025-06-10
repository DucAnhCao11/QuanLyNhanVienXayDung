package com.example.quan_ly_nhan_vien.mappers;

import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserCreationRequest;
import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.UserResponse;
import com.example.quan_ly_nhan_vien.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "role", ignore = true)
    User toUser(UserCreationRequest request);

    @Mapping(target = "role", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    @Mapping(source = "role", target = "role")
    UserResponse toUserResponse(User user);
}
