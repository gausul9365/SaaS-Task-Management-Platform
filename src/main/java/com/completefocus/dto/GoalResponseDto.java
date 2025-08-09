package com.completefocus.dto;

import com.completefocus.model.Goal.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalResponseDto {
    private Long id;
    private String title;
    private String description;
    private String date;
    private Status status;
    private String userName;
}
