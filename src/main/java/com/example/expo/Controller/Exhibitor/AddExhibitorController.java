package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/addexhibitor")
public class AddExhibitorController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExhibitorStandService exhibitorStandService;

    @GetMapping
    public String getCreateStand(){

        return "AddExhibitorView";

    }

    @PostMapping
    public String postAddStand(@RequestParam String email, HttpServletRequest req){

        User current = userService.findByMail((String)req.getSession().getAttribute("username"));
        User addUser = userService.findByMail(email);
        Integer standId = exhibitorStandService.findStandByUserId(current.getId());
        exhibitorStandService.addExhbitorStand(addUser.getId(),standId);


        return "redirect:/viewstand";
    }

}
