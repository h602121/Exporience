package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Service.*;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/viewstand")
public class ViewStandController {

    @Autowired
    public VoteService voteService;

    @Autowired
    public StandService standService;

    @Autowired
    public ExhibitorStandService exhibitorStandService;

    @Autowired
    public UserService userService;

    @Autowired
    public ExpoPointsHandlerService handlerService;

    @GetMapping
    public String getViewStand(Model model, HttpServletRequest req){

        if(req.getSession().getAttribute("stand") == null){
            return "redirect:/createstand";
        }
        Integer userId = userService.findByMail((String)req.getSession().getAttribute("username")).getId();
        Integer standId = exhibitorStandService.findStandByUserId(userId);


        List<Vote> votes = voteService.getAllVotesById(handlerService.getAllVotesByStandId(standId));

        double average = 0;
        for(Vote vote : votes){
            average = vote.getContentRating();
            average += vote.getPosterRating();
            average += vote.getPresentationRating();
        }

        average = average/votes.size();

        model.addAttribute("avg_rating", average);

        model.addAttribute("stand", standService.getStandbyStandId(standId));
        return "ViewStandView";
    }

//    @PostMapping
//    public String postViewStand(HttpServletRequest req){
//        return "";
//
//    }

}
