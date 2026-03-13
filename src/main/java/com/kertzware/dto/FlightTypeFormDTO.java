package com.kertzware.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Flight Type DTO for form
 */
@Data
@Builder
public class FlightTypeFormDTO {
    private Long id;
    private String name;
}
