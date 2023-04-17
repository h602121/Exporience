package com.example.expo.Controller.Spectator;

import com.example.expo.util.LoginUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spectatormain")

public class SpectatorMainController {
    @GetMapping
    public String getSpectatorMain(HttpSession session) {

        if(!LoginUtil.erBrukerInnlogget(session)) return "redirect:spectatorlogin";

        return "SpectatorMainView";
    }
    @PostMapping
    public String postSpectatorMain() {

        return "redirect:spectatormain";
    }
}
