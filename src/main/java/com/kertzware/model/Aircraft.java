package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aircraft {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String registration;

    @Column(nullable = false)
    private String model;

    private Float totalAirframeHours;

    @Column(nullable = false)
    private Boolean isGrounded;

    private Double emptyWeight;

    private Double MTOW;

    private Double wingspan;

    private Integer capacity;

    private Double cargo;

    private Double length;

    private Double height;

    private Double wingArea;

    private Double fuelCapacity;

    private Double aspectRatio;

    @ManyToOne
    private AircraftType aircraftType;

}
