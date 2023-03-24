package com.example.expo.Controller;


import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Service.ExpoPointsHandlerService;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/standlist")
public class StandListController {

    @Autowired
    public ExpoPointsHandlerService pointsHandlerService;

    @Autowired
    public VoteService voteService;

    @Autowired
    public StandService standService;

    @GetMapping
    public String getStandList(Model model){


        List<Stand> stands = standService.getAllStands();
        model.addAttribute("stands", stands);
        return "StandListView";
    }

    @PostMapping
    public String postStandList(){


        //int voteId = voteService.addVote(1,2,3);





        return "redirect:/standlist";
    }
}
