package com.kertzware.service;

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

}
