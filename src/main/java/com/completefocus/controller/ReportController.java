package com.completefocus.controller;

import com.completefocus.dto.*;
import com.completefocus.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/daily/{userId}")
    public ReportResponseDto getDaily(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getDailyReport(userId, date);
    }

    @GetMapping("/weekly/{userId}")
    public ReportResponseDto getWeekly(@PathVariable Long userId) {
        return service.getWeeklyReport(userId);
    }

    @GetMapping("/team")
    public List<UserReportDto> getTeamReport() {
        return service.getTeamReport();
    }
}
