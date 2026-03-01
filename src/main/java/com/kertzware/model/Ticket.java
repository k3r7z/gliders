package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Ticket {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private Long code;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, precision = 20, scale = 2)
    private Boolean isPaid = Boolean.FALSE;

    @OneToOne
    private Flight flight;
}
