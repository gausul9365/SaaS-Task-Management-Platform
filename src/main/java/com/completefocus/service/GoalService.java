package com.completefocus.service;

import com.completefocus.dto.GoalDto;
import com.completefocus.dto.GoalResponseDto;

import java.util.List;

public interface GoalService {
    GoalResponseDto createGoal(GoalDto dto);
    List<GoalResponseDto> getGoalsByUser(Long userId);
    GoalResponseDto closeGoal(Long goalId);
}
