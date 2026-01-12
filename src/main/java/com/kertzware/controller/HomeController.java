package com.kertzware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
    This controller serves a simple "Hello world" message at the /api/hello-world endpoint
    to test the app works fine. It includes a basic login functionality.
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
