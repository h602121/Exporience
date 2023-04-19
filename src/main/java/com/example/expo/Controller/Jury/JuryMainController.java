package com.example.expo.Controller.Jury;

import com.example.expo.Model.Role;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/jurymain")

public class JuryMainController {



    @GetMapping
    public String getJuryMain(HttpSession session) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:exhibitorlogin";
        }

        return "JuryMainView";
    }

    @PostMapping
    public String postJuryMain(){

        return "redirect:jurymain";
    }
}
