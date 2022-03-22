package com.example.tourAgency.controllers;

import com.example.tourAgency.models.TourTasks;
import com.example.tourAgency.services.TourTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TourTaskController {
    private final TourTaskService tourTaskService;
    public TourTaskController(TourTaskService tourTaskService) {
        this.tourTaskService = tourTaskService;
    }

    @GetMapping("/new-task")
    public String newTask(Model model){
        model.addAttribute("newTask", new TourTasks());
        return "newTask";
    }

    @PostMapping
    public String creatTask(@ModelAttribute("newTask") TourTasks tourTasks){
        tourTaskService.createTask(tourTasks);
        return "redirect:/task";
    }
}
