package com.completefocus.controller;

import com.completefocus.dto.*;
import com.completefocus.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserDto dto) {
        return service.createUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/role/{role}")
    public List<UserResponseDto> getByRole(@PathVariable String role) {
        return service.getUsersByRole(role);
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
