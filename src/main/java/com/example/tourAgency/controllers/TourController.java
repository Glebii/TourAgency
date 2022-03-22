package com.example.tourAgency.controllers;

import com.example.tourAgency.models.Country;
import com.example.tourAgency.services.CountryTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/former/tour")
public class TourController{
    private final CountryTypeService countryTypeService;
    public TourController(CountryTypeService countryTypeService) {
        this.countryTypeService = countryTypeService;
    }
    @GetMapping
    public String tourMenu(){
        return "former/tourMenu";
    }

    @GetMapping("/country")
    public String countryList(Model model){
        model.addAttribute("countryList", countryTypeService.countryList());
        return "forms/countryList";
    }
    @GetMapping("/country/newCountry")
    public String newCountry(Model model){
        model.addAttribute("country", new Country());
        return "forms/country_form";
    }
    @PostMapping("/country/save")
    public String createPosition(Country country){
        countryTypeService.createCountry(country);
        return "redirect:/forms/tour/country";
    }
    @GetMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id){
        countryTypeService.deleteCountry(id);
        return "redirect:/forms/tour/country";
    }




}
