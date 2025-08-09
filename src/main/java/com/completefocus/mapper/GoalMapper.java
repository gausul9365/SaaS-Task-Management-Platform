package com.completefocus.mapper;

import com.completefocus.dto.*;
import com.completefocus.model.Goal;
import com.completefocus.model.User;

import java.time.LocalDate;

public class GoalMapper {

    public static Goal toEntity(GoalDto dto, User user) {
        Goal goal = new Goal();
        goal.setTitle(dto.getTitle());
        goal.setDescription(dto.getDescription());
        goal.setDate(LocalDate.parse(dto.getDate()));
        goal.setStatus(Goal.Status.OPEN);
        goal.setUser(user);
        return goal;
    }

    public static GoalResponseDto toDto(Goal goal) {
        return new GoalResponseDto(
                goal.getId(),
                goal.getTitle(),
                goal.getDescription(),
                goal.getDate().toString(),
                goal.getStatus(),
                goal.getUser().getName()
        );
    }
}
