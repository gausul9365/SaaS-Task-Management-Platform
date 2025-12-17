package com.completefocus.controller;

import com.completefocus.dto.*;
import com.completefocus.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponseDto create(@Valid @RequestBody TaskDto dto) {
        return service.createTask(dto);
    }

    @GetMapping("/user/{userId}")
    public List<TaskResponseDto> getByUser(@PathVariable Long userId) {
        return service.getTasksByUser(userId);
    }

    @PutMapping("/{taskId}/complete")
    public TaskResponseDto complete(@PathVariable Long taskId) {
        return service.markTaskComplete(taskId);
    }
}
