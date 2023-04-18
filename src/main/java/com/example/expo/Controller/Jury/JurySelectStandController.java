package com.example.expo.Controller.Jury;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.expo.util.LoginUtil;


@Controller
@RequestMapping("/juryselectstand")
public class JurySelectStandController {
    
    @GetMapping
    public String getJurySelectStand(HttpSession session, RedirectAttributes ra) {

        if(!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("error_message", "Skrrt du er ikke logget inn");
            return "redirect:jurylogin";
        }
        return "RatingSelectorView";
    }

    @PostMapping
    public String postJurySelectStand(){
        return "redirect:jurymain";
    }
}
