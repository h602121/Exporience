package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spectatormain")

public class SpectatorMainController {
    @GetMapping
    public String getSpectatorMain() {

        return "SpectatorMainView";
    }
    @PostMapping
    public String postSpectatorMain() {

        return "redirect:spectatormain";
    }
}
