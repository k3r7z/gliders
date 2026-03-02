package com.kertzware.repository;

import com.kertzware.model.Aerodrome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AerodromeRepository extends JpaRepository<Aerodrome, Long> {
}