package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Service.StandService;
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

    @GetMapping
    public String getCreateStand(){

        return "CreateStandView";

    }
    @PostMapping
    public String postCreateStand(@RequestParam String name, @RequestParam String stand_description, HttpServletRequest req){

        System.out.println(req.getAttribute("username"));

//    Integer standId = standService.addStand(name, stand_description);
//    expoStandService.addExhbitorStand(userId, standId);

    standService.addStand(name, stand_description);

        return "redirect:/viewStandview";

    }

}
