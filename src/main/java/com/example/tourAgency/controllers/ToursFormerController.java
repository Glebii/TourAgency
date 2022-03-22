package com.example.tourAgency.controllers;

import com.example.tourAgency.models.Status;
import com.example.tourAgency.models.TourTasks;
import com.example.tourAgency.services.TourTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/former")
public class ToursFormerController {
    private final TourTaskService tourTaskService;

    public ToursFormerController(TourTaskService tourTaskService) {
        this.tourTaskService = tourTaskService;
    }

    @GetMapping
    public String toursFormer(){
        return "forms/toursFormer";
    }
    //Tour Task
    //All Tour Tasks
    @GetMapping("/tour-task")
    public String allTourTask(Model model){
        model.addAttribute("taskList", tourTaskService.tourTasksList());
        return "forms/tourTaskList";
    }
    //Save edited Task
    @PostMapping("/tour-task/save")
    public String editTask(TourTasks tourTask) {
        tourTaskService.createTask(tourTask);
        return "redirect:/forms/tour-task";
    }
    //Edit Task
    @GetMapping("/tour-task/edit/{id}")
    public String TourTaskForm(@PathVariable("id") Long id, Model model){
        TourTasks tourTasks= tourTaskService.find(id);
        model.addAttribute("task", tourTasks);
        List<Status> statusList = tourTaskService.statusList();
        model.addAttribute("statuses", statusList);
        return "forms/task_form";
    }

}
