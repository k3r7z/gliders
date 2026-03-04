package com.kertzware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        String username = principal.getName();
        // Find a way to get the user's profile by its username
        return "profile";
    }
}
