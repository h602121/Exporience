package com.example.expo.Controller.Exhibitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/exhibitormain")

public class ExhibitorMainController {
    @GetMapping
    public String getExhibitorMain() {

        return "ExhibitorMainView";
    }

    @PostMapping
    public String postExhibitorMain() {

        return "redirect:exhibitormain";
    }
}
