package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createspectator")
public class CreateSpectatorController {

    @GetMapping
    public String getCreateSpectator(){
        return "CreateSpectatorView";
    }

    @PostMapping
    public String postCreateSpectator(){
        return "redirect:createspectator";
    }
}
