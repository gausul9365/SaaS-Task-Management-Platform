package com.completefocus.service.impl;

import com.completefocus.dto.*;
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

    public TaskServiceImpl(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    @Override
    public TaskResponseDto createTask(TaskDto dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = TaskMapper.toEntity(dto, user);
        taskRepo.save(task);
        return TaskMapper.toDto(task);
    }

    @Override
    public List<TaskResponseDto> getTasksByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return taskRepo.findByUser(user)
                .stream().map(TaskMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto markTaskComplete(Long taskId) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(Task.Status.COMPLETED);
        taskRepo.save(task);

        return TaskMapper.toDto(task);
    }
}
