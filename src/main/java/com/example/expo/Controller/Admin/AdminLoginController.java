package com.example.expo.Controller.Admin;


import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class AdminLoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/adminlogin")
    public String getAdminLogin() {
        return "AdminLoginView";
    }

    @PostMapping("/adminlogin")
    public String postLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest req, RedirectAttributes ra, HttpSession session) {


        if (!userService.findUserByEmail(username)) {
            ra.addFlashAttribute("error_message", "User does not exist");
            return "redirect:/adminlogin";

        }
        if (!(userService.validateLogin(username, password))) {
            ra.addFlashAttribute("error_message", "Innlogging feilet");
            return "redirect:/adminlogin";
        } else {
            LoginUtil.loggInnBruker(req, 4);
            req.getSession().setAttribute("username", username);
            return "redirect:adminmain";

        }


    }


}
