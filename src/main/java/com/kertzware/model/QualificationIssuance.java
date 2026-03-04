package com.kertzware.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class QualificationIssuance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(optional = false)
    private Qualification qualification;

    @ManyToOne(optional = false)
    private Member member;

    @Column(nullable = false)
    private LocalDate emissionDate;

    private LocalDate expirationDate;
}
