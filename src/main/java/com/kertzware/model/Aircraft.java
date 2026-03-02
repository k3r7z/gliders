package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aircraft {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String registration;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Float totalAirframeHours = 0.0f;

    @Column(nullable = false)
    private Boolean isGrounded;

    @Column(nullable = false)
    private Double weight;

    @ManyToOne
    private AircraftType aircraftType;

}
