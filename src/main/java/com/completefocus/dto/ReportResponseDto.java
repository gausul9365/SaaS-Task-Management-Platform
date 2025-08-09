package com.completefocus.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDto {
    private String userName;
    private int goalsSet;
    private int goalsCompleted;
    private int tasksDone;
    private int totalTimeSpent; // in minutes
}
