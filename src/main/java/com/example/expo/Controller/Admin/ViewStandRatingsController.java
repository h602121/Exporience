package com.example.expo.Controller.Admin;

import com.example.expo.Model.Service.ExpoPointsHandlerService;
import com.example.expo.StandScoreAvg;
import com.example.expo.VoteListByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/standratings")
public class ViewStandRatingsController {

    @Autowired
    private ExpoPointsHandlerService handlerService;

    @GetMapping
    public String getViewStandRating(Model model){

        List<StandScoreAvg> scores = handlerService.getAverageScoreAllStands();
        model.addAttribute("scores", scores);

        return "AllRatingsView";
    }


}
