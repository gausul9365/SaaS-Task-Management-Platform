package com.completefocus.mapper;

import com.completefocus.dto.GoalDto;
import com.completefocus.dto.GoalResponseDto;
import com.completefocus.model.Goal;
import com.completefocus.model.User;

import java.time.LocalDate;

public class GoalMapper {

    public static Goal toEntity(GoalDto dto, User user, LocalDate date) {
        Goal goal = new Goal();
        goal.setTitle(dto.getTitle());
        goal.setDescription(dto.getDescription());
        goal.setDate(date);
        goal.setUser(user);
        goal.setStatus(Goal.Status.OPEN);
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
