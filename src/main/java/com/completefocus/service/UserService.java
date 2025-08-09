package com.completefocus.service;

import com.completefocus.dto.UserDto;
import com.completefocus.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserDto dto);
    List<UserResponseDto> getAllUsers();
    List<UserResponseDto> getUsersByRole(String role);
    UserResponseDto getUserById(Long id);
}
