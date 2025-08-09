package com.completefocus.dto;

import com.completefocus.model.User.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private Role role;
}
