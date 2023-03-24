package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String helloWorld(){
        System.out.println("HEIHEI");
        return "MainView";
    }

    @PostMapping
    public String postSpectatorLogin(){
        return "redirect:spectatorlogin";
    }

}
