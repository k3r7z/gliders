package com.kertzware.controller;

import com.kertzware.dto.MemberDTO;
import com.kertzware.model.Member;
import com.kertzware.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        String username = principal.getName();
        MemberDTO dto = memberService.getProfileByUsername(username);
        model.addAttribute("profile", dto);
        return "profile";
    }

    @GetMapping("/socios")
    public String members(Model model, Principal principal) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/index";
    }

    @PostMapping("/socios/dar-de-baja/{id}")
    public String deleteMember(@PathVariable Long id,
                               RedirectAttributes attributes) {
        memberService.dismissMember(id);
        attributes.addFlashAttribute("successMessage", "Socio dado de baja correctamente");
        return "redirect:/socios";
    }
}
