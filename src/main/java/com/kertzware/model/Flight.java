package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.ZonedDateTime;

@Entity
@Data
public class Flight {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long code;

    @ManyToOne
    private FlightType flightType;

    @ManyToOne
    private Aerodrome departure;

    @ManyToOne
    private Aerodrome destination;

    @Column(nullable = false)
    private ZonedDateTime startTime;

    @Column(nullable = false)
    private ZonedDateTime stopTime;

    @ManyToOne(optional = false)
    private Member pilotInCommand;

    @ManyToOne
    private Member instructor;

    @ManyToOne(optional = false)
    private Aircraft aircraft;

    @ManyToOne
    private Aircraft towAirplane;

}
