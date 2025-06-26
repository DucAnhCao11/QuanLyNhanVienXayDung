package com.example.quan_ly_nhan_vien.mappers;

import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.CreateStaffRequest;
import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.StaffUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.quan_ly_nhan_vien.dto.responses.StaffResponse;
import com.example.quan_ly_nhan_vien.entities.Staff;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    @Mapping(target = "position", ignore = true)
    @Mapping(target = "user", ignore = true)
    Staff toStaff(CreateStaffRequest request);

    @Mapping(target = "position", ignore = true)
    @Mapping(target = "user", ignore = true)
    void toUpdateStaff(@MappingTarget Staff staff, StaffUpdateRequest request);

    @Mapping(source = "user", target = "userResponse")
    @Mapping(source = "position", target = "positionResponse")
    StaffResponse toStaffResponse(Staff staff);

}
