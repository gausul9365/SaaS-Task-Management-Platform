package com.completefocus.service;

import com.completefocus.dto.*;

import java.util.List;

public interface TaskService {
    TaskResponseDto createTask(TaskDto dto);
    List<TaskResponseDto> getTasksByUser(Long userId);
    TaskResponseDto markTaskComplete(Long taskId);
}
