package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Qualification {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private QualificationType qualificationType;
}
