package com.kertzware.service;

import com.kertzware.dto.AerodromeFormDTO;
import com.kertzware.model.Aerodrome;
import com.kertzware.repository.AerodromeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AerodromeService {

    private final AerodromeRepository aerodromeRepository;

    public AerodromeService(AerodromeRepository aerodromeRepository){
        this.aerodromeRepository = aerodromeRepository;
    }

    public List<Aerodrome> findAll(){
        return aerodromeRepository.findAll();
    }

    public List<AerodromeFormDTO> findAerodromesForSelection(){
        return aerodromeRepository.findAll().stream()
                .map( aerodrome -> AerodromeFormDTO.builder()
                        .id(aerodrome.getId())
                        .name((aerodrome.getIcaoCode() != null ? aerodrome.getIcaoCode() : aerodrome.getLocalCode()) + " - " + aerodrome.getName())
                        .build()
                ).toList();
    }
}
