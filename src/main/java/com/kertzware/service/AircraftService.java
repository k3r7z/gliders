package com.kertzware.service;

import com.kertzware.dto.AircraftFormDTO;
import com.kertzware.model.Aircraft;
import com.kertzware.repository.AircraftRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> findAll(){
        return aircraftRepository.findAll();
    }

    /**
     * Returns a list of Aircraft DTO made for form selection
     * @return the list of dtos
     */
    public List<AircraftFormDTO> findAircraftsForSelection(){
        return aircraftRepository.findAll().stream()
                .map( aircraft -> AircraftFormDTO.builder()
                        .id(aircraft.getId())
                        .registration(aircraft.getRegistration())
                        .type(aircraft.getAircraftType().getName())
                        .build()
                ).toList();
    }

}
