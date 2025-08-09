package com.completefocus.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalDto {
    private String title;
    private String description;
    private String date; // "2025-08-01"
    private Long userId;
}
