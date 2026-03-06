package com.kertzware.service;

import com.kertzware.dto.FlightDTO;
import com.kertzware.model.Flight;
import com.kertzware.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }


    public List<FlightDTO> findFlightsByMemberId(Long memberId){
        List<Flight> flights = flightRepository.findFlightsByPilotInCommandId(memberId);
        List<FlightDTO> dtos = new ArrayList<>();

        for(Flight flight : flights){
            dtos.add(
                FlightDTO.builder()
                    .type(flight.getFlightType().getName())
                    .date(flight.getStartTime().format(DATE_FORMATTER))
                    .startTime(flight.getStartTime().format(TIME_FORMATTER))
                    .departureCode(flight.getDeparture().getIcaoCode() != null ? flight.getDeparture().getIcaoCode() : flight.getDeparture().getLocalCode())
                    .destinationCode(flight.getDestination().getIcaoCode() != null ? flight.getDestination().getIcaoCode() : flight.getDestination().getLocalCode())
                    .stopTime(flight.getStopTime().format(TIME_FORMATTER))
                    .duration(calculateDuration(flight))
                    .aircraftReg(flight.getAircraft().getRegistration())
                    .build()
            );
        }
        return dtos;
    }


    /**
     * Calculates flight duration even considering a flight covers two days
     * @param flight the flight
     * @return the duration in string format for the DTO
     */
    private String calculateDuration(Flight flight) {
        // This works perfectly even if stopTime is on the next day
        Duration duration = Duration.between(flight.getStartTime(), flight.getStopTime());
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%02d:%02d hs", hours, minutes);
    }
}
