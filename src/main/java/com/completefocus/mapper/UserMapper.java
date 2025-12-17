package com.completefocus.mapper;

import com.completefocus.dto.UserDto;
import com.completefocus.dto.UserResponseDto;
import com.completefocus.model.User;

import java.time.LocalDateTime;

public class UserMapper {

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(String.valueOf(dto.getRole())); // Direct enum assignment
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(), // Direct enum
                user.getCreatedAt().toString()
        );
    }
}
