package com.example.expo.Controller;

import com.example.expo.Model.Entity.StandScoreAvg;
import com.example.expo.Model.Service.ExpoPointsHandlerService;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/winner")
public class SeWinnerController {

    @Autowired
    private ExpoPointsHandlerService handlerService;

    @GetMapping
    public String getWinner(Model model, HttpSession session) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:spectatorlogin";
        }

        List<StandScoreAvg> scores2 = handlerService.getAverageScoreAllStands();

        List<StandScoreAvg> scores = new ArrayList<>();

        scores.add(scores2.get(0));
        scores.add(scores2.get(1));
        scores.add(scores2.get(2));

        model.addAttribute("scores", scores);

        return "AllRatingsView";
    }


}