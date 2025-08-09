package com.completefocus.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReportDto {
    private Long userId;
    private String userName;
    private ReportResponseDto report;
}
