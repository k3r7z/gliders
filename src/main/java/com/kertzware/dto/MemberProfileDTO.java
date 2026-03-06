package com.kertzware.dto;

import com.kertzware.model.Flight;
import com.kertzware.model.QualificationIssuance;
import com.kertzware.model.RoleRecord;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class MemberProfileDTO {
    private String name;
    private Integer memberId;
    private String email;
    private List<RoleRecord> activeRoles;
    private List<QualificationIssuance> licesesIssuances;
    private List<QualificationIssuance> ratingsIssuances;
    private List<QualificationIssuance> medicalIssuances;
    private List<FlightDTO> flights;
}
