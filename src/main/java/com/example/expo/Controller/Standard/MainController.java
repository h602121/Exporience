package com.example.expo.Controller.Standard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {
    @GetMapping
    public String helloWorld(){
        return "MainView";
    }

    @PostMapping
    public String postSpectatorLogin(){
        return "redirect:spectatorlogin";
    }

}
