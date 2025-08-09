package com.completefocus.service.impl;

import com.completefocus.dto.*;
import com.completefocus.model.*;
import com.completefocus.repository.*;
import com.completefocus.service.ReportService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final UserRepository userRepo;
    private final GoalRepository goalRepo;
    private final TaskRepository taskRepo;

    public ReportServiceImpl(UserRepository userRepo, GoalRepository goalRepo, TaskRepository taskRepo) {
        this.userRepo = userRepo;
        this.goalRepo = goalRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public ReportResponseDto getDailyReport(Long userId, LocalDate date) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        List<Goal> goals = goalRepo.findByUserAndDate(user, date);
        List<Task> tasks = taskRepo.findByUserAndCreatedAtBetween(
                user,
                date.atStartOfDay(),
                date.atTime(LocalTime.MAX)
        );

        return buildReport(user.getName(), goals, tasks);
    }

    @Override
    public ReportResponseDto getWeeklyReport(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(6); // past 7 days

        List<Goal> goals = goalRepo.findByUser(user).stream()
                .filter(g -> !g.getDate().isBefore(start))
                .collect(Collectors.toList());

        List<Task> tasks = taskRepo.findByUserAndCreatedAtBetween(
                user, start.atStartOfDay(), now.atTime(LocalTime.MAX)
        );

        return buildReport(user.getName(), goals, tasks);
    }

    @Override
    public List<UserReportDto> getTeamReport() {
        List<User> allUsers = userRepo.findAll();
        List<UserReportDto> reports = new ArrayList<>();

        for (User user : allUsers) {
            ReportResponseDto report = getWeeklyReport(user.getId());
            reports.add(new UserReportDto(user.getId(), user.getName(), report));
        }

        return reports;
    }

    private ReportResponseDto buildReport(String userName, List<Goal> goals, List<Task> tasks) {
        int goalsSet = goals.size();
        int goalsCompleted = (int) goals.stream().filter(g -> g.getStatus() == Goal.Status.CLOSED).count();
        int tasksDone = (int) tasks.stream().filter(t -> t.getStatus() == Task.Status.COMPLETED).count();
        int timeSpent = tasks.stream().mapToInt(Task::getTimeSpent).sum();

        return new ReportResponseDto(userName, goalsSet, goalsCompleted, tasksDone, timeSpent);
    }
}
