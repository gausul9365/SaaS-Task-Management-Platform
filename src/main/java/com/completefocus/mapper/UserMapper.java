package com.completefocus.mapper;

import com.completefocus.dto.*;
import com.completefocus.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserMapper {

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return user;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}
