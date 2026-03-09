package com.kertzware.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class FlightEntryDTO {
    @NotNull(message = "Debe ingresar el ")
    private Long flightTypeId;

    @NotNull(message = "Debe ingresar el aeródromo de salida")
    private Long departureId;

    @NotNull(message = "Debe ingresar el aeródromo de destino")
    private Long destinationId;

    @NotNull(message = "Debe ingresar la hora de inicio del vuelo")
    private ZonedDateTime startTime;

    @NotNull(message = "Debe ingresar la hora final del vuelo")
    private ZonedDateTime stopTime;

    @NotNull(message = "Debe ingresar el piloto/alumno")
    private Long pilotInCommandId;

    private Long instructorId;

    @NotNull(message = "Debe seleccionar una aeronave")
    private Long aircraftId;

    private Long towAirplane;
}
