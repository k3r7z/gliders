package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class RoleRecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDate since;

    private LocalDate until;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;

    @PrePersist
    private void onCreate() {
        this.since = LocalDate.now();
    }
}
