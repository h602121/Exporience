package com.example.expo.Controller.Admin;

import com.example.expo.StandScoreAvg;
import com.example.expo.VoteListByUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/standratings")
public class ViewStandRatingsController {

    @GetMapping
    public String getViewStandRating(){


        return "AllRatingsView";
    }


}
