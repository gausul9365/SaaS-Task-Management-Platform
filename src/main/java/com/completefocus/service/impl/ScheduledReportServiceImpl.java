package com.completefocus.service.impl;

import com.completefocus.dto.ReportResponseDto;
import com.completefocus.model.User;
import com.completefocus.repository.UserRepository;
import com.completefocus.service.EmailService;
import com.completefocus.service.ReportService;
import com.completefocus.service.ScheduledReportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduledReportServiceImpl implements ScheduledReportService {

    private final ReportService reportService;
    private final EmailService emailService;
    private final UserRepository userRepo;

    public ScheduledReportServiceImpl(ReportService reportService, EmailService emailService, UserRepository userRepo) {
        this.reportService = reportService;
        this.emailService = emailService;
        this.userRepo = userRepo;
    }

    /**
     * Runs every day at 8 AM
     */
    @Override
    @Scheduled(cron = "0 0 8 * * *")
    public void sendDailyReports() {
        LocalDate today = LocalDate.now();
        List<User> users = userRepo.findAll();

        for (User user : users) {
            ReportResponseDto report = reportService.getDailyReport(user.getId(), today);

            Map<String, Object> variables = new HashMap<>();
            variables.put("date", today.toString());
            variables.put("userName", report.getUserName());
            variables.put("goalsSet", report.getGoalsSet());
            variables.put("goalsCompleted", report.getGoalsCompleted());
            variables.put("tasksDone", report.getTasksDone());
            variables.put("timeSpent", report.getTotalTimeSpent());

            try {
                emailService.sendHtmlMail(user.getEmail(), "Daily Report - " + today, variables, "daily-report");
            } catch (jakarta.mail.MessagingException e) {
                // log the error (can use proper logger here)
                System.err.println(" Failed to send daily report to " + user.getEmail() + ": " + e.getMessage());
            }
        }
    }

    /**
     * Runs every Monday at 8 AM
     */
    @Override
    @Scheduled(cron = "0 0 8 * * MON")
    public void sendWeeklyReports() {
        List<User> users = userRepo.findAll();

        for (User user : users) {
            ReportResponseDto report = reportService.getWeeklyReport(user.getId());

            Map<String, Object> variables = new HashMap<>();
            variables.put("date", LocalDate.now().toString());
            variables.put("userName", report.getUserName());
            variables.put("goalsSet", report.getGoalsSet());
            variables.put("goalsCompleted", report.getGoalsCompleted());
            variables.put("tasksDone", report.getTasksDone());
            variables.put("timeSpent", report.getTotalTimeSpent());

            try {
                emailService.sendHtmlMail(user.getEmail(), "Weekly Report", variables, "weekly-report");
            } catch (jakarta.mail.MessagingException e) {
                System.err.println(" Failed to send weekly report to " + user.getEmail() + ": " + e.getMessage());
            }
        }
    }
}
