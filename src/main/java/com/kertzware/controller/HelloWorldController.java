package com.kertzware.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    This controller serves a simple "Hello world" message at the /api/hello-world endpoint
    to test the app works fine. It includes a basic login functionality.
 */

@RestController
public class HelloWorldController {

    @GetMapping("api/hello-world")
    public String helloWorld(){
        return "Hello world";
    }
}
