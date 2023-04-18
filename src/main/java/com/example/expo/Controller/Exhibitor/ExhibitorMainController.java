package com.example.expo.Controller.Exhibitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.expo.util.LoginUtil;

@Controller
@RequestMapping ("/exhibitormain")

public class ExhibitorMainController {
    @GetMapping
    public String getExhibitorMain(HttpSession session, RedirectAttributes ra, Model model, HttpServletRequest request) {
        if(!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("error_message", "Skrrt du er ikke logget inn");
            return "redirect:/spectatorlogin";
        }
        return "ExhibitorMainView";
    }

    @PostMapping
    public String postExhibitorMain() {

        return "redirect:exhibitormain";
    }
}
