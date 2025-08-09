package com.completefocus.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String title;
    private String description;
    private int timeSpent;
    private Long userId;
}
