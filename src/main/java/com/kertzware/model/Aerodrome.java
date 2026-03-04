package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Aerodrome {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true)
    private String icaoCode;

    @Column(unique = true)
    private String localCode;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Province location;
}
