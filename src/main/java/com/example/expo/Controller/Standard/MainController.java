package com.example.expo.Controller.Standard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.expo.Model.Role;
import com.example.expo.util.LoginUtil;

@Controller
@RequestMapping("/home")
public class MainController {
    @GetMapping
    public String helloWorld(HttpServletRequest req, RedirectAttributes ra, HttpSession session){

        if(LoginUtil.erBrukerInnlogget(session)){
            if(req.getSession().getAttribute(("roleId")).equals(Role.EXHIBITOR)){
                return "ExhibitorMainView";
            }
            if(req.getSession().getAttribute(("roleId")).equals(Role.SPECTATOR)){
                return "SpectatorMainView";
            }
            if(req.getSession().getAttribute(("roleId")).equals(Role.JURY)){
                return "JuryMainView";
            }
            if(req.getSession().getAttribute(("roleId")).equals(Role.ADMIN)){
                return "AdminMainView";
            }
        }
        return "MainView";
    }

    @PostMapping
    public String postSpectatorLogin(){
        return "redirect:spectatorlogin";
    }

}
