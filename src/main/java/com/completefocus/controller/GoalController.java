package com.completefocus.controller;

import com.completefocus.dto.*;
import com.completefocus.service.GoalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    @PostMapping
    public GoalResponseDto create(@Valid @RequestBody GoalDto dto) {
        return service.createGoal(dto);
    }

    @GetMapping("/user/{userId}")
    public List<GoalResponseDto> getByUser(@PathVariable Long userId) {
        return service.getGoalsByUser(userId);
    }

    @PutMapping("/{goalId}/close")
    public GoalResponseDto closeGoal(@PathVariable Long goalId) {
        return service.closeGoal(goalId);
    }
}
