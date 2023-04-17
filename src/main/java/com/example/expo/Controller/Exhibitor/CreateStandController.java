package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/createstand")
public class CreateStandController {

    @Autowired
    private StandService standService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExhibitorStandService expoStandService;

    @GetMapping
    public String getCreateStand(HttpSession session){

        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:exhibitorlogin";
        }

        return "CreateStandView";

    }
    @PostMapping
    public String postCreateStand(@RequestParam String name, @RequestParam String stand_description, HttpServletRequest req){


        Integer userId = userService.findByMail((String)req.getSession().getAttribute("username")).getId();
        Integer standId = standService.addStand(name, stand_description);
        expoStandService.addExhbitorStand(userId, standId);


        return "redirect:/viewstand";

    }

}
