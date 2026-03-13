package com.kertzware.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Member DTO intended for form selections
 */
@Data
@Builder
public class MemberFormDTO {
    private Long id;
    private String fullName;
}
