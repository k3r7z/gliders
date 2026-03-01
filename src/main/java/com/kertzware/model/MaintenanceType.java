package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MaintenanceType {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
