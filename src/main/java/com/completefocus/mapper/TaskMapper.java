package com.completefocus.mapper;

import com.completefocus.dto.TaskDto;
import com.completefocus.dto.TaskResponseDto;
import com.completefocus.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskMapper {

    public static Task toEntity(TaskDto dto, User user, Goal goal) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setTimeSpent(dto.getTimeSpent());
        task.setStatus(Task.Status.PENDING);
        task.setCreatedAt(LocalDateTime.now());
        task.setUser(user);
        task.setGoal(goal);
        return task;
    }

    public static TaskResponseDto toDto(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getTimeSpent(),
                task.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                task.getStatus(),
                task.getUser().getName(),
                task.getGoal() != null ? task.getGoal().getId() : null
        );
    }
}
