package com.kertzware.controller;

import com.kertzware.dto.FlightEntryDTO;
import com.kertzware.service.AerodromeService;
import com.kertzware.service.AircraftService;
import com.kertzware.service.FlightService;
import com.kertzware.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/vuelos")
public class FlightController {

    private final MemberService memberService;
    private final AerodromeService aerodromeService;
    private final AircraftService aircraftService;
    private final FlightService flightService;

    public FlightController(
            MemberService memberService,
            AerodromeService aerodromeService,
            AircraftService aircraftService,
            FlightService flightService
    ){
        this.memberService = memberService;
        this.aerodromeService = aerodromeService;
        this.aircraftService = aircraftService;
        this.flightService = flightService;
    }

    @GetMapping("/nuevo")
    public String flightForm(Model model){
        model.addAttribute("flight", new FlightEntryDTO());
        populateFormModel(model);
        return "flights/flight-form";
    }

    @PostMapping("/nuevo")
    public String createFlight(@Valid @ModelAttribute("flight") FlightEntryDTO flight,
                               BindingResult result,
                               RedirectAttributes attributes,
                               Model model){
        if(result.hasErrors()){
            populateFormModel(model);
            System.out.println(flight);
            attributes.addFlashAttribute("errorMessage", "Ocurrió un error al intentar registrar el vuelo");
            return "flights/flight-form";
        }

        flightService.saveFlight(flight);
        attributes.addFlashAttribute("successMessage", "Vuelo registrado exitosamente!");
        return "redirect:/";
    }

    private void populateFormModel(Model model){
        model.addAttribute("aircrafts", aircraftService.findAircraftsForSelection());
        model.addAttribute("flightTypes", flightService.findFlightTypesForSelection());
        model.addAttribute("aerodromes", aerodromeService.findAerodromesForSelection());
        model.addAttribute("pilots", memberService.findPilotsForSelection());
        model.addAttribute("instructors", memberService.findInstructorsForSelection());
    }

}
