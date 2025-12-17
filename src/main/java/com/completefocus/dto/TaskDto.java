package com.completefocus.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(0)
    private int timeSpent;

    @NotNull
    private Long userId;

    private Long goalId; // Optional — attach task to a goal
}
