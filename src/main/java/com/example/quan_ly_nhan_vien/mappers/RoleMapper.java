package com.example.quan_ly_nhan_vien.mappers;

import com.example.quan_ly_nhan_vien.dto.responses.RoleResponse;
import com.example.quan_ly_nhan_vien.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse toRoleResponse(Role role);
}
