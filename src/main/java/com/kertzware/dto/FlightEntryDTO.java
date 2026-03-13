package com.kertzware.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class FlightEntryDTO {
    @NotNull(message = "Debe ingresar el tipo de vuelo")
    private Long flightTypeId;

    @NotNull(message = "Debe ingresar el aeródromo de salida")
    private Long departureId;

    @NotNull(message = "Debe ingresar el aeródromo de destino")
    private Long destinationId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Debe ingresar la hora de inicio del vuelo")
    private LocalDateTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Debe ingresar la hora final del vuelo")
    private LocalDateTime stopTime;

    @NotNull(message = "Debe ingresar el piloto/alumno")
    private Long pilotInCommandId;

    private Long instructorId;

    @NotNull(message = "Debe seleccionar una aeronave")
    private Long aircraftId;

    private Long towAirplaneId;
}
