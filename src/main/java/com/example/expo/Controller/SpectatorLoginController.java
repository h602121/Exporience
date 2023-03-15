package com.example.expo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spectatorlogin")
public class SpectatorLoginController {
    @GetMapping
    public String getSpectatorLogin(){
        return "SpectatorLoginView";
    }

    @PostMapping
    public String postLogin() {

        return "redirect:spectatorlogin";
    }

    //@RequestParam String phonenumber, @RequestParam String password, HttpServletRequest request, RedirectAttributes ra
}
