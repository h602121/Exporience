package com.example.expo.Controller;

import com.example.expo.Model.Service.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String postCreateStand(@RequestParam String name, @RequestParam String stand_description){


    standService.addStand(name, stand_description);

        return "redirect:/viewStandview";

    }

}
