package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Engine {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private Float totalHours;

    @Column(nullable = false)
    private Float weight;

    @ManyToOne(optional = false)
    private Aircraft aircraft;
}
