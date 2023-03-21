package com.example.expo.Controller;


import com.example.expo.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class SpectatorLoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/spectatorlogin")
    public String getSpectatorLogin(){
        return "SpectatorLoginView";
    }

    @PostMapping("/spectatorlogin")
    public String postLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes ra) {

        if(!(userService.findSpectatorByEmailAndPassword(username,password))){
            ra.addFlashAttribute("error_message", "Innlogging feilet");
            return "redirect:/spectatorlogin";
        }
        return "redirect:spectatormain";
    }


}
