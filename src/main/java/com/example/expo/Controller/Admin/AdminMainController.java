package com.example.expo.Controller.Admin;

import com.example.expo.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminmain")

public class AdminMainController {
    @GetMapping
    public String getAdminMain(HttpSession session) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:adminlogin";
        }

        return "AdminMainView";
    }

    @PostMapping
    public String postAdminMain() {

        return "redirect:adminmain";
    }
}
