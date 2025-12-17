package com.completefocus.dto;

import com.completefocus.model.Task.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private int timeSpent;
    private String createdAt;
    private Status status;
    private String userName;
    private Long goalId; // Optional
}
