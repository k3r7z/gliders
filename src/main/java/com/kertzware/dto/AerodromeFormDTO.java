package com.kertzware.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Aerodrome DTO intended for forms
 */
@Data
@Builder
public class AerodromeFormDTO {
    private Long id;
    private String name;
}
