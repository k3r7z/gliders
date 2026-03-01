package com.kertzware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FlightType {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
