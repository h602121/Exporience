package com.example.expo.Controller.Exhibitor;

import com.example.expo.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/exhibitormain")

public class ExhibitorMainController {
    @GetMapping
    public String getExhibitorMain(HttpSession session) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:exhibitorlogin";
        }

        return "ExhibitorMainView";
    }

    @PostMapping
    public String postExhibitorMain() {

        return "redirect:exhibitormain";
    }
}
