package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ratingselector")
public class RatingSelectorController {

    @GetMapping
    public String getRatingSelector(){
        return "RatingSelectorView";
    }

    @PostMapping
    public String postRatingSelector(){
        return "redirect:standlist";
    }
}
