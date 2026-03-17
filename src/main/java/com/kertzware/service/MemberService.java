package com.kertzware.service;

import com.kertzware.dto.FlightDTO;
import com.kertzware.dto.MemberDTO;
import com.kertzware.dto.MemberFormDTO;
import com.kertzware.model.*;
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

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /**
     * Deletes a member using its id
     * @param id member's id
     */
    public void deleteMemberById(Long id){
        if(!memberRepository.existsById(id))
            throw new EntityNotFoundException("No se encontró al socio con ID " + id);
        memberRepository.deleteById(id);
    }

    /**
     * Returns a list of all club pilots available for form selection
     * @return the list of DTOs
     */
    public List<MemberFormDTO> findPilotsForSelection(){
        return memberRepository.findAllPilots().stream()
                .map(member -> MemberFormDTO.builder()
                        .id(member.getId())
                        .fullName(member.getFirstName() + ' ' + member.getLastName())
                        .build())
                .toList();
    }

    public List<MemberFormDTO> findInstructorsForSelection(){
        return memberRepository.findInstructors().stream()
                .map( member -> MemberFormDTO.builder()
                        .id(member.getId())
                        .fullName(member.getFirstName() + ' ' + member.getLastName())
                        .build())
                .toList();
    }

    public MemberDTO getProfileByUsername(String username){
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

        return MemberDTO.builder()
                .fullName(member.getFirstName() + ' ' + member.getLastName())
                .email(member.getEmail())
                .memberId(member.getMemberId())
                .activeRoles(activeRoles)
                .licenseIssuances(licenseIssuances)
                .ratingIssuances(ratingIssuances)
                .medicalIssuances(medicalIssuances)
                .flights(flights)
                .build();
    }
}
