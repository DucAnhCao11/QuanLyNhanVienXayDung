package com.example.quan_ly_nhan_vien.controller;

import com.example.quan_ly_nhan_vien.dto.requests.userRequest.UserCreationRequest;
import com.example.quan_ly_nhan_vien.dto.responses.RoleResponse;
import com.example.quan_ly_nhan_vien.dto.responses.UserResponse;
import com.example.quan_ly_nhan_vien.services.interfaces.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    private UserCreationRequest request;
    private UserResponse response;
    private RoleResponse roleResponse;
    private LocalDate dob;

    @BeforeEach
    void setUp(){
        objectMapper.registerModule(new JavaTimeModule());
    }

    @BeforeEach
    void initData(){
        dob = LocalDate.of(2011, 2, 21);

        roleResponse = RoleResponse.builder()
                .maRole("NHAN_VIEN")
                .tenRole("Nhân viên")
                .build();

        request = UserCreationRequest.builder()
                .idRole(3)
                .email("test@gmail.com")
                .matKhau("Caoanh123@")
                .ngayTao(dob)
                .trangThai(1)
                .build();

        response = UserResponse.builder()
                .id(3L)
                .role(roleResponse)
                .email("test@gmail.com")
                .ngayTao(dob)
                .trangThai(1)
                .build();
    }


    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void createUser_validRequest_success() throws Exception {
        // Given
        String content = objectMapper.writeValueAsString(request);

        Mockito.when(userService.createUser(ArgumentMatchers.any()))
                        .thenReturn(response);

        // When, Then
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code")
                        .value(1000)
        );
    }
}
