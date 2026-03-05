package com.kertzware.dto;

import com.kertzware.model.RoleRecord;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class MemberProfileDTO {
    private String firstName;
    private String lastName;
    private Integer memberId;
    private String email;
    private List<RoleRecord> activeRoles;
}
