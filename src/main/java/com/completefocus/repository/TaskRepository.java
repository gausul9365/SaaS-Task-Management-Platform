package com.completefocus.repository;

import com.completefocus.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByUserAndCreatedAtBetween(User user, LocalDateTime start, LocalDateTime end);
}
