package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/jurymain")

public class JuryMainController {
    @GetMapping
    public String getJuryMain() {

        return "JuryMainView";
    }

    @PostMapping
    public String postJuryMain(){
        return "redirect:jurymain";
    }
}
