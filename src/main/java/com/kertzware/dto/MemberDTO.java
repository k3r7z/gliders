package com.kertzware.dto;

import com.kertzware.model.QualificationIssuance;
import com.kertzware.model.RoleRecord;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class MemberDTO {
    private String fullName;
    private Integer memberId;
    private String email;
    private List<RoleRecord> activeRoles;
    private List<QualificationIssuance> licenseIssuances;
    private List<QualificationIssuance> ratingIssuances;
    private List<QualificationIssuance> medicalIssuances;
    private List<FlightDTO> flights;
}
