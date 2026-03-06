package com.kertzware.repository;

import com.kertzware.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findFlightsByPilotInCommandId(Long memberId);
}
