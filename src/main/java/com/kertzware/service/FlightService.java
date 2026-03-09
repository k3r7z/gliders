package com.kertzware.service;

import com.kertzware.dto.FlightDTO;
import com.kertzware.dto.FlightEntryDTO;
import com.kertzware.dto.FlightTypeFormDTO;
import com.kertzware.model.Aerodrome;
import com.kertzware.model.Flight;
import com.kertzware.model.FlightType;
import com.kertzware.repository.*;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class that manages processes regarding flights
 */
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightTypeRepository flightTypeRepository;
    private final AircraftRepository aircraftRepository;
    private final AerodromeRepository aerodromeRepository;
    private final MemberRepository memberRepository;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FlightService(FlightRepository flightRepository,
                         FlightTypeRepository flightTypeRepository,
                         AircraftRepository aircraftRepository,
                         AerodromeRepository aerodromeRepository,
                         MemberRepository memberRepository
                         ){
        this.flightRepository = flightRepository;
        this.flightTypeRepository = flightTypeRepository;
        this.aircraftRepository = aircraftRepository;
        this.aerodromeRepository = aerodromeRepository;
        this.memberRepository = memberRepository;
    }


    public void saveFlight(FlightEntryDTO dto){
        Flight flight = new Flight();

        flight.setFlightType( flightTypeRepository.getReferenceById(dto.getFlightTypeId()) );
        flight.setAircraft( aircraftRepository.getReferenceById(dto.getAircraftId()) );
        flight.setDeparture( aerodromeRepository.getReferenceById(dto.getDepartureId()) );
        flight.setStartTime( dto.getStartTime() );
        flight.setStopTime( dto.getStopTime() );
        flight.setDestination( aerodromeRepository.getReferenceById(dto.getDestinationId()) );
        flight.setPilotInCommand( memberRepository.getReferenceById(dto.getPilotInCommandId()) );

        if(dto.getTowAirplaneId() != null )
            flight.setTowAirplane( aircraftRepository.getReferenceById(dto.getTowAirplaneId()));

        flightRepository.save(flight);
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
                    .departureCode(getCode(flight.getDeparture()))
                    .destinationCode(getCode(flight.getDestination()))
                    .stopTime(flight.getStopTime().format(TIME_FORMATTER))
                    .duration(calculateDuration(flight))
                    .aircraftReg(flight.getAircraft().getRegistration())
                    .build()
            );
        }
        return dtos;
    }


    /**
     * Returns a list of flight types DTO for a form
     * @return the list of DTOs
     */
    public List<FlightTypeFormDTO> findFlightTypesForSelection(){
        return flightTypeRepository.findAll().stream()
                .map( type -> FlightTypeFormDTO.builder()
                        .id(type.getId())
                        .name(type.getName())
                        .build()
                ).toList();
    }


    /**
     * Returns the ICAO designation, or the local otherwise
     * @param aerodrome the aerodrome
     * @return the designation of the aerodrome
     */
    private String getCode(Aerodrome aerodrome){
        return aerodrome.getIcaoCode() != null ? aerodrome.getIcaoCode() : aerodrome.getLocalCode();
    }

    /**
     * Calculates flight duration even considering a flight covers two days
     * @param flight the flight
     * @return the duration in string format for the DTO
     */
    private String calculateDuration(Flight flight) {
        Duration duration = Duration.between(flight.getStartTime(), flight.getStopTime());
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%02d:%02d hs", hours, minutes);
    }
}
