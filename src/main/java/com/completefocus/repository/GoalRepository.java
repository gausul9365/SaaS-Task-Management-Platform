package com.completefocus.repository;

import com.completefocus.model.Goal;
import com.completefocus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUser(User user);
    List<Goal> findByUserAndDate(User user, java.time.LocalDate date);
}
