package com.example.tourAgency.controllers;

import com.example.tourAgency.models.Staff;
import com.example.tourAgency.services.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    @GetMapping("/newStaff")
    public String newStaff(Model model) {
        model.addAttribute("newStaff", new Staff());
        return "newStaff";
    }

    @PostMapping
    public String createStaff(@ModelAttribute("newStaff") Staff staff) {
        staffService.creatStaff(staff);
        return "redirect:/staff";
    }

    @GetMapping
    public String allStaff(Model model){
        model.addAttribute(staffService.staffList());
        return "staffList";
    }
}
