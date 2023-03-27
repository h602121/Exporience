package com.example.expo.Controller.Jury;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jurylogin")
public class JuryLoginController {

    @GetMapping
    public String getjurylogin() {
        return "JuryLoginView";
    }

    @PostMapping
    public String postjurylogin() {

        return "jurylogin";
    }

}
