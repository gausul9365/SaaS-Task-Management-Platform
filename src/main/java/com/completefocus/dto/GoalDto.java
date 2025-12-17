package com.completefocus.dto;


import lombok.*;
import jakarta.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in yyyy-MM-dd format")
    private String date; // "2025-08-01"

    @NotNull
    private Long userId;
}
