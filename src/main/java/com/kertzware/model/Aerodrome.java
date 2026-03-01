package com.kertzware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Aerodrome {

    @GeneratedValue
    @Id
    private Long id;

    @Column(unique = true)
    private String icaoCode;

    @Column(unique = true)
    private String localCode;

    @Column(nullable = false)
    private String name;

}
