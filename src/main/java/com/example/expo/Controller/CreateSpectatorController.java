package com.example.expo.Controller;

import com.example.expo.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/createspectator")
public class CreateSpectatorController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getCreateSpectator(){
        return "CreateSpectatorView";
    }

    @PostMapping
    public String postCreateSpectator(@RequestParam String phonenumber,@RequestParam String firstName,
                                      @RequestParam String lastName,@RequestParam
                                      String email,@RequestParam String password,
                                      @RequestParam String confirmPassword){
        if (password.equals(confirmPassword)){
        userService.createSpectator(phonenumber,firstName,lastName,email,password,1);
        return "redirect:/spectatormain";
        }

        return "redirect:/createspectator";
    }
}
