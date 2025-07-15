package com.example.quan_ly_nhan_vien.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.quan_ly_nhan_vien.Helper.StaffHelper;
import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.CreateStaffRequest;
import com.example.quan_ly_nhan_vien.dto.requests.StaffRequest.StaffUpdateRequest;
import com.example.quan_ly_nhan_vien.dto.responses.StaffResponse;
import com.example.quan_ly_nhan_vien.entities.Position;
import com.example.quan_ly_nhan_vien.entities.Staff;
import com.example.quan_ly_nhan_vien.entities.User;
import com.example.quan_ly_nhan_vien.exceptions.AppException;
import com.example.quan_ly_nhan_vien.exceptions.PositionErrorCode;
import com.example.quan_ly_nhan_vien.exceptions.StaffErrorCode;
import com.example.quan_ly_nhan_vien.exceptions.UserErrorCode;
import com.example.quan_ly_nhan_vien.mappers.StaffMapper;
import com.example.quan_ly_nhan_vien.repositories.PositionRepository;
import com.example.quan_ly_nhan_vien.repositories.StaffRepository;
import com.example.quan_ly_nhan_vien.repositories.UserRepository;
import com.example.quan_ly_nhan_vien.services.interfaces.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
    private static final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StaffMapper staffMapper;

    private Staff findStaff(Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new AppException(StaffErrorCode.STAFF_NOT_FOUND));
    }

    private Position findPosition(Integer id) {
        return positionRepository
                .findById(id)
                .orElseThrow(() -> new AppException(PositionErrorCode.POSITION_NOT_FOUND));
    }

    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new AppException(UserErrorCode.USER_NOT_FOUND));
    }

    private String generateUniqueStaffCode() {
        String code;

        do {
            code = StaffHelper.generateStaffCode();
        } while (staffRepository.existsByMaNhanVien(code));
        return code;
    }

    private void validateStaff(CreateStaffRequest request) {
        if (staffRepository.existsByEmail(request.getEmail()))
            throw new AppException(StaffErrorCode.EMAIL_ALREADY_EXISTS);

        if (staffRepository.existsBySoCCCD(request.getSoCCCD()))
            throw new AppException(StaffErrorCode.CCCD_ALREADY_EXISTS);

        if (staffRepository.existsBySoDienThoai(request.getSoDienThoai()))
            throw new AppException(StaffErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
    }

    private void validateStaffForUpdate(Long id, StaffUpdateRequest request) {
        staffRepository.findByEmail(request.getEmail()).ifPresent(st -> {
            if (!st.getId().equals(id)) {
                throw new AppException(StaffErrorCode.EMAIL_ALREADY_EXISTS);
            }
        });

        staffRepository.findBySoDienThoai(request.getSoDienThoai()).ifPresent(st -> {
            if (!st.getId().equals(id)) {
                throw new AppException(StaffErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
            }
        });

        staffRepository.findBySoCCCD(request.getSoCCCD()).ifPresent(st -> {
            if (!st.getId().equals(id)) {
                throw new AppException(StaffErrorCode.CCCD_ALREADY_EXISTS);
            }
        });
    }

    public List<StaffResponse> getAll() {
        return staffRepository.findAll().stream()
                .map(staffMapper::toStaffResponse)
                .toList();
    }

    @Override
    public StaffResponse getById(Long id) {
        return staffMapper.toStaffResponse(findStaff(id));
    }

    @Override
    @Transactional
    public StaffResponse staffCreation(CreateStaffRequest request) {
        Position position = findPosition(request.getIdChucVu());
        validateStaff(request);

        Staff staff = staffMapper.toStaff(request);
        staff.setPosition(position);
        staff.setMaNhanVien(generateUniqueStaffCode());

        return staffMapper.toStaffResponse(staffRepository.save(staff));
    }

    @Override
    @Transactional
    public StaffResponse updateStaff(StaffUpdateRequest request, Long id) {
        Position position = findPosition(request.getIdChucVu());
        Staff staff = findStaff(id);

        validateStaffForUpdate(id, request);
        staffMapper.toUpdateStaff(staff, request);
        staff.setPosition(position);

        return staffMapper.toStaffResponse(staffRepository.save(staff));
    }
}
