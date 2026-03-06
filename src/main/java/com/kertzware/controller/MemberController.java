package com.kertzware.controller;

import com.kertzware.dto.MemberProfileDTO;
import com.kertzware.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        String username = principal.getName();
        MemberProfileDTO dto = memberService.getProfileByUsername(username);
        model.addAttribute("profile", dto);
        return "profile";
    }
}
