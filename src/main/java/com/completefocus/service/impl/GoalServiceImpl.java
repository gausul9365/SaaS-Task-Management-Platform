package com.completefocus.service.impl;

import com.completefocus.dto.*;
import com.completefocus.exception.ResourceNotFoundException;
import com.completefocus.model.*;
import com.completefocus.repository.*;
import com.completefocus.service.GoalService;
import com.completefocus.mapper.GoalMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepo;
    private final UserRepository userRepo;

    public GoalServiceImpl(GoalRepository goalRepo, UserRepository userRepo) {
        this.goalRepo = goalRepo;
        this.userRepo = userRepo;
    }

    @Override
    public GoalResponseDto createGoal(GoalDto dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Goal goal = GoalMapper.toEntity(dto, user, LocalDate.parse(dto.getDate()));
        goalRepo.save(goal);
        return GoalMapper.toDto(goal);
    }

    @Override
    public List<GoalResponseDto> getGoalsByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return goalRepo.findByUser(user)
                .stream().map(GoalMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GoalResponseDto closeGoal(Long goalId) {
        Goal goal = goalRepo.findById(goalId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found"));

        goal.setStatus(Goal.Status.CLOSED);
        goalRepo.save(goal);

        return GoalMapper.toDto(goal);
    }
}
