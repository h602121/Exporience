package com.example.expo.Controller;

import com.example.expo.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ratingselector")
public class RatingSelectorController {

    @GetMapping
    public String getRatingSelector(HttpSession session){

        if(!LoginUtil.erBrukerInnlogget(session)){
            return "redirect:spectatorlogin";
        }
        return "RatingSelectorView";
    }

    @PostMapping
    public String postRatingSelector(){
        return "redirect:standlist";
    }
}
