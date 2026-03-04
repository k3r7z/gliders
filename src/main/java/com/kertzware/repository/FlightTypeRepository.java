package com.kertzware.repository;

import com.kertzware.model.FlightType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTypeRepository extends JpaRepository<FlightType, Long> {
}
