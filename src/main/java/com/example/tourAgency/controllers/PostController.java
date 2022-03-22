package com.example.tourAgency.controllers;

import com.example.tourAgency.models.Post;
import com.example.tourAgency.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/posts" )
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //List of Positions
    @GetMapping
    public String allPosts(Model model){
        model.addAttribute("postList", postService.postList());
        return "allPosts";
    }
    //Create new Position
    @GetMapping("/newPosition")
    public String newPost(Model model){
        model.addAttribute("newPost", new Post());
        return "newPost";
    }
    @PostMapping
    public String createPosition(@ModelAttribute("newPost") Post post){
        postService.creatPost(post);
        return "redirect:/positions";
    }

    //Delete position
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        postService.deletePost(id);
        return "redirect:/positions";
    }

    //Edit position
    @GetMapping("/edit/{id}")
    public ModelAndView viewEditPostForm(@PathVariable(name = "id") Long id){

        ModelAndView mav = new ModelAndView("update");
        Post post = postService.updateById(id);
        mav.addObject("post", post);
        return mav;
    }
    //Save edited position
    @PostMapping("/save-post")
    public String savePost(@ModelAttribute("post") Post post){
        postService.creatPost(post);
        return "redirect:/positions";
    }
}
