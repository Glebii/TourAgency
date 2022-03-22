package com.example.tourAgency.controllers;

import com.example.tourAgency.models.Post;
import com.example.tourAgency.models.Staff;
import com.example.tourAgency.models.Status;
import com.example.tourAgency.models.TourTasks;
import com.example.tourAgency.services.PostService;
import com.example.tourAgency.services.StaffService;
import com.example.tourAgency.services.TourTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/deputy-director")
public class DeputyDirectorController {
    private final PostService postService;
    private final StaffService staffService;
    private final TourTaskService tourTaskService;
    public DeputyDirectorController(PostService postService, StaffService staffService, TourTaskService tourTaskService) {
        this.postService = postService;
        this.staffService = staffService;
        this.tourTaskService = tourTaskService;
    }
    @GetMapping
    public String deputyDirector(){
        return "director/deputyDirector";
    }

    // All about positions //
    @GetMapping("/positions")
    public String allPosts(Model model){
        model.addAttribute("postList", postService.postList());
        return "director/postList";
    }
    @GetMapping("/positions/newPosition")
    public String newPost(Model model){
        model.addAttribute("post", new Post());
        return "director/post_form";
    }
    @PostMapping("/positions/save")
    public String createPosition(Post post){
        postService.creatPost(post);
        return "redirect:/deputy-director/positions";
    }
    @GetMapping("/positions/delete/{id}")
    public String deletePosition(@PathVariable("id") Long id){
        postService.deletePost(id);
        return "redirect:/deputy-director/positions";
    }
    @GetMapping("/positions/edit/{id}")
    public ModelAndView viewEditPostForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("director/post_form");
        Post post = postService.updateById(id);
        mav.addObject("post", post);
        return mav;
    }






    // All about staff //
    @GetMapping("/staff")
    public String allStaff(Model model){
        model.addAttribute("staffList", staffService.staffList());
        return "director/staffList";
    }
    @GetMapping("/staff/newStaff")
    public String newStaff(Model model) {
        List<Post> postList = postService.postList();
        model.addAttribute("staff", new Staff());
        model.addAttribute("listPost", postList);
        return "director/staff_form";
    }
    @PostMapping("/staff/save")
    public String createStaff(Staff staff) {
        staffService.creatStaff(staff);
        return "redirect:/deputy-director/staff";
    }

    @GetMapping("/staff/edit/{id}")
    public String staffForm(@PathVariable("id") Long id, Model model){
        Staff staff = staffService.findById(id);
        model.addAttribute("staff", staff);
        List<Post> postList = postService.postList();
        model.addAttribute("listPost", postList);
        return "director/staff_form";
    }
    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable("id") Long id){
        staffService.deletePost(id);
        return "redirect:/deputy-director/staff";
    }





    // All about tour //
    @GetMapping("/tour-task")
    public String allTourTask(Model model){
        model.addAttribute("taskList", tourTaskService.tourTasksList());
        return "director/tourTaskList";
    }
    @GetMapping("/tour-task/newTask")
    public String newTask(Model model) {
        List<Status> statusList = tourTaskService.statusList();
        model.addAttribute("task", new TourTasks());
        model.addAttribute("statuses", statusList);
        return "director/task_form";
    }
    @PostMapping("/tour-task/save")
    public String createTask(TourTasks tourTask) {
        tourTaskService.createTask(tourTask);
        return "redirect:/deputy-director/tour-task";
    }
    @GetMapping("/tour-task/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        tourTaskService.deleteTask(id);
        return "redirect:/deputy-director/tour-task";
    }
}
