package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exhibitorlogin")
public class ExhibitorLoginController {
    
    @GetMapping
    public String getExhibitorLogin(){
        return "ExhibitorLoginView";
    }

    @PostMapping
    public String postExhibitorLogin(){
        return "exhibitorlogin";
    }
}
