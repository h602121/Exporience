package com.example.expo.Controller.Spectator;


import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Service.*;
import com.example.expo.util.GeneralFormatUtil;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/standlist")
public class StandListController {

    @Autowired
    public ExpoService expoService;

    @Autowired
    public UserService userService;

    @Autowired
    public ExpoPointsHandlerService pointsHandlerService;

    @Autowired
    public VoteService voteService;

    @Autowired
    public StandService standService;

    @GetMapping
    public String getStandList(Model model, HttpSession session) {

        if (!LoginUtil.erBrukerInnlogget(session)) return "redirect:/spectatorlogin";
        List<Stand> stands = standService.getAllStands();
        model.addAttribute("stands", stands);
        return "StandListView";
    }

    @PostMapping
    public String postStandList(@RequestParam HashMap<String, String> map, @RequestParam Integer stand_id, HttpServletRequest req, RedirectAttributes ra) {

        Map<String, Integer> newMap = GeneralFormatUtil.validNumberFormat(map);

        if (newMap.get("poster_presentation") == null || newMap.get("content_presentation") == null || newMap.get("rating_presentation") == null) {
            ra.addFlashAttribute("error_rating_message", "Invalid vote, all values on one stand must be selected");
            return "redirect:/standlist";
        }

        HttpSession session = req.getSession();
        User username = userService.findByMail((String) session.getAttribute("username"));
        if (!pointsHandlerService.checkIfUseridAndStandIdHasAlreadyVoted(username.getId(), stand_id)) {
            ra.addFlashAttribute("error_rating_message", "You have already voted on this stand. Cant vote more than once per stand");
            return "redirect:/standlist";
        }

        int voteId = voteService.addVote(newMap.get("poster_presentation"), newMap.get("content_presentation"), newMap.get("rating_presentation"));
        pointsHandlerService.addVoteHandler(voteId, username.getId(), stand_id, (Integer) session.getAttribute("expo"));
        ra.addFlashAttribute("confirmation_rating_message", "Voted on stand");

        return "redirect:/standlist";
    }
}
