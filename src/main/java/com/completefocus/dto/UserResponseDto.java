package com.completefocus.dto;

import com.completefocus.model.User.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private String createdAt;

    public UserResponseDto(Long id, String name, String email, String role, String string) {
    }
}
