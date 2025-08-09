package com.completefocus.service;

import com.completefocus.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    ReportResponseDto getDailyReport(Long userId, LocalDate date);
    ReportResponseDto getWeeklyReport(Long userId);
    List<UserReportDto> getTeamReport();
}
