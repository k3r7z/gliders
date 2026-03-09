package com.kertzware.controller;

import com.kertzware.dto.FlightEntryDTO;
import com.kertzware.service.AerodromeService;
import com.kertzware.service.AircraftService;
import com.kertzware.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vuelos")
public class FlightController {

    private final MemberService memberService;
    private final AerodromeService aerodromeService;
    private final AircraftService aircraftService;

    public FlightController(
            MemberService memberService,
            AerodromeService aerodromeService,
            AircraftService aircraftService
    ){
        this.memberService = memberService;
        this.aerodromeService = aerodromeService;
        this.aircraftService = aircraftService;
    }

    @GetMapping("/nuevo")
    public String flightForm(Model model){
        model.addAttribute("flight", new FlightEntryDTO());
        model.addAttribute("aircrafts", aircraftService.findAll());
        model.addAttribute("aerodromes", aerodromeService.findAll());
        model.addAttribute("pilots", memberService.findAllPilotsForSelection());
        return "flights/flight-form";
    }

    @PostMapping("/nuevo")
    public String createFlight(Model model){
        System.out.println("Registrado vuelo nuevo");
        return "flights/flight-form";
    }

}
