package com.kertzware.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Aircraft DTO intended for forms
 */
@Data
@Builder
public class AircraftFormDTO {
    private Long id;
    private String registration;
    private String type;
}
