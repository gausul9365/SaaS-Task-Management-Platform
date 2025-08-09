package com.completefocus.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int timeSpent; // in minutes

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private LocalDateTime createdAt;

    public enum Status {
        PENDING,
        COMPLETED
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
