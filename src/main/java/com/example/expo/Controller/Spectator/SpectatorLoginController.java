package com.example.expo.Controller.Spectator;


import com.example.expo.Model.Role;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.expo.util.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class SpectatorLoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/spectatorlogin")
    public String getSpectatorLogin(HttpSession session, RedirectAttributes ra, Model model, HttpServletRequest request) {

        return "SpectatorLoginView";
    }

    @PostMapping("/spectatorlogin")
    public String postLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest req, RedirectAttributes ra, HttpSession session) {


            if (!userService.findUserByEmail(username)) {
                ra.addFlashAttribute("error_message", "User does not exist");
                return "redirect:/spectatorlogin";

            }
            if (!(userService.validateLogin(username, password))) {
                ra.addFlashAttribute("error_message", "Innlogging feilet");
                return "redirect:/spectatorlogin";
            } else {
                LoginUtil.loggInnBruker(req, 1);
                req.getSession().setAttribute("username", username);
                req.getSession().setAttribute("userId", userService.findByMail(username).getId());
                req.getSession().setAttribute("roleId", Role.SPECTATOR);
                return "redirect:spectatormain";

            }



    }


}
