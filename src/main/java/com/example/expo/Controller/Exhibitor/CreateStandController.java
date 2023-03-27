package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public String getCreateStand(){

        return "CreateStandView";

    }
    @PostMapping
    public String postCreateStand(@RequestParam String name, @RequestParam String stand_description, HttpServletRequest req){


        Integer userId = userService.findByMail((String)req.getSession().getAttribute("username")).getId();
        Integer standId = standService.addStand(name, stand_description);
        expoStandService.addExhbitorStand(userId, standId);


        return "redirect:/viewStandview";

    }

}
