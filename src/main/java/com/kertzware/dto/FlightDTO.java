package com.kertzware.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightDTO {
    private String type;
    private String date;
    private String departureCode;
    private String destinationCode;
    private String startTime;
    private String stopTime;
    private String duration;
    private String aircraftReg;
}
