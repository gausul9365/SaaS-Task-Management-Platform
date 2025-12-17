package com.completefocus.service.impl;

import com.completefocus.dto.*;
import com.completefocus.exception.ResourceNotFoundException;
import com.completefocus.mapper.TaskMapper;
import com.completefocus.model.*;
import com.completefocus.repository.*;
import com.completefocus.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepo;
    private final UserRepository userRepo;
    private final GoalRepository goalRepo;

    public TaskServiceImpl(TaskRepository taskRepo, UserRepository userRepo, GoalRepository goalRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
        this.goalRepo = goalRepo;
    }

    @Override
    public TaskResponseDto createTask(TaskDto dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Goal goal = null;
        if (dto.getGoalId() != null) {
            goal = goalRepo.findById(dto.getGoalId())
                    .orElseThrow(() -> new ResourceNotFoundException("Goal not found"));
        }

        Task task = TaskMapper.toEntity(dto, user, goal);
        taskRepo.save(task);
        return TaskMapper.toDto(task);
    }

    @Override
    public List<TaskResponseDto> getTasksByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return taskRepo.findByUser(user)
                .stream().map(TaskMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto markTaskComplete(Long taskId) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setStatus(Task.Status.COMPLETED);
        taskRepo.save(task);

        return TaskMapper.toDto(task);
    }
}
