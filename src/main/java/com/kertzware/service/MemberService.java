package com.kertzware.service;

import com.kertzware.dto.MemberProfileDTO;
import com.kertzware.model.Member;
import com.kertzware.model.RoleRecord;
import com.kertzware.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public MemberProfileDTO getProfileByUsername(String username){
        Member member = memberRepository.findByUserUsername(username).
                orElseThrow( () -> new EntityNotFoundException("No member found for user: " + username));
        List<RoleRecord> activeRoles = memberRepository.findActiveRolesByUserId(member.getUser().getId());


        return MemberProfileDTO.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .memberId(member.getMemberId())
                .activeRoles(activeRoles)
                .build();
    }
}
