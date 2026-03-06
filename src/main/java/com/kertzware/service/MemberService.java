package com.kertzware.service;

import com.kertzware.dto.FlightDTO;
import com.kertzware.dto.MemberProfileDTO;
import com.kertzware.model.*;
import com.kertzware.repository.FlightRepository;
import com.kertzware.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final FlightService flightService;

    public MemberService(MemberRepository memberRepository, FlightService flightService){
        this.memberRepository = memberRepository;
        this.flightService = flightService;
    }

    public MemberProfileDTO getProfileByUsername(String username){
        Member member = memberRepository.findByUserUsername(username).
                orElseThrow( () -> new EntityNotFoundException("No member found for user: " + username));
        List<RoleRecord> activeRoles = memberRepository.findActiveRolesByUserId(member.getUser().getId());
        List<QualificationIssuance> issuances = memberRepository.findActiveQualificationsByMemberId(member.getId());
        List<QualificationIssuance> licenseIssuances = new ArrayList<>();
        List<QualificationIssuance> ratingIssuances = new ArrayList<>();
        List<QualificationIssuance> medicalIssuances = new ArrayList<>();

        for(QualificationIssuance issuance : issuances){
            Qualification qualification = issuance.getQualification();
            switch (qualification.getQualificationType().getName()) {
                case "License" -> licenseIssuances.add(issuance);
                case "Rating" -> ratingIssuances.add(issuance);
                case "Medical" -> medicalIssuances.add(issuance);
            }
        }

        List<FlightDTO> flights = flightService.findFlightsByMemberId(member.getId());

        return MemberProfileDTO.builder()
                .name(member.getFirstName() + ' ' + member.getLastName())
                .email(member.getEmail())
                .memberId(member.getMemberId())
                .activeRoles(activeRoles)
                .licesesIssuances(licenseIssuances)
                .ratingsIssuances(ratingIssuances)
                .medicalIssuances(medicalIssuances)
                .flights(flights)
                .build();
    }
}
