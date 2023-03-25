package com.example.expo.Controller;

import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/viewstand")
public class ViewStandController {

    @Autowired
    public UserService userService;

    @GetMapping
    public String getViewStand(HttpServletRequest req){

        if(req.getSession().getAttribute("stand") == null){
            return "redirect:/createstand";
        }
        return "ViewStandView";
    }

//    @PostMapping
//    public String postViewStand(HttpServletRequest req){
//        return "";
//
//    }

}
