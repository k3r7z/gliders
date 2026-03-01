package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Qualification {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String details;

    @ManyToOne
    private QualificationType qualificationType;
}
