package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class MaintenanceRecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    private MaintenanceType maintenanceType;

    @ManyToOne
    private Engine engine;

    @Column(nullable = false)
    private Float engineHours;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String workbench;

}
