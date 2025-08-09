package com.completefocus.service.impl;

import com.completefocus.dto.*;
import com.completefocus.model.User;
import com.completefocus.repository.UserRepository;
import com.completefocus.service.UserService;
import com.completefocus.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserResponseDto createUser(UserDto dto) {
        User user = UserMapper.toEntity(dto);
        repo.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return repo.findAll().stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> getUsersByRole(String role) {
        return repo.findByRole(User.Role.valueOf(role.toUpperCase())).stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDto(user);
    }
}
