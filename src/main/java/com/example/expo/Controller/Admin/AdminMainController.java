package com.example.expo.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminmain")

public class AdminMainController {
    @GetMapping
    public String getAdminMain() {

        return "AdminMainView";
    }

    @PostMapping
    public String postAdminMain() {

        return "redirect:adminmain";
    }
}
