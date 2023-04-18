package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.Model.Service.WinnerTimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private WinnerTimeService winnerService;


    @GetMapping
    public String getCreateStand(){

        return "CreateStandView";

    }
    @PostMapping
    public String postCreateStand(@RequestParam String name, @RequestParam String stand_description, HttpServletRequest req){


        Integer userId = userService.findByMail((String)req.getSession().getAttribute("username")).getId();
        if(standService.noActive()){
            winnerService.setNotCurrent();
        }
        Stand tempStand=new Stand(name, stand_description);
        Integer standId = standService.addStand(tempStand);
        expoStandService.addExhbitorStand(userId, standId);
        if(standService.noActive()){
            winnerService.setAllInactive();
        }
      
        return "redirect:/viewstand";

    }

}
