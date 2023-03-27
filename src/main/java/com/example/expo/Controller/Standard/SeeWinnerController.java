package com.example.expo.Controller.Standard;

import com.example.expo.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/seewinner")
public class SeeWinnerController {

    @GetMapping
    public String getSeeWinner(HttpSession session) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:spectatorlogin";
        }
        return "SeeWinnerView";
    }

    @PostMapping
    public String postSeeWinner() {
        return "redirect:seewinner";
    }
}
