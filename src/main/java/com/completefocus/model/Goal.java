package com.completefocus.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "goals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    public enum Status {
        OPEN,
        CLOSED
    }

    // Association
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
