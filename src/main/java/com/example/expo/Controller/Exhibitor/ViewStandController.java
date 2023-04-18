package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Entity.ExhibitorStand;
import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.UserVotes;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.expo.util.LoginUtil;
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

    @Autowired
    public UserVotesService userVotesService;

    @GetMapping
    public String getViewStand(Model model, HttpServletRequest req, HttpSession session){
        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:spectatorlogin";
        }
        User username = userService.findByMail((String) session.getAttribute("username"));
        
        List <Stand> exhibitorStand = exhibitorStandService.findStandByUserId(username.getId());

        if(exhibitorStand == null || !standService.isActive(exhibitorStand)){
            return "redirect:/createstand";
        }

        model.addAttribute("votes", exhibitorStand);
       
        
       // Integer userId = userService.findByMail((String)req.getSession().getAttribute("username")).getId();
       // List<Stand> standId = exhibitorStandService.findFullStandByUserId(userId);


        return "ViewStandView";
    }

//    @PostMapping
//    public String postViewStand(HttpServletRequest req){
//        return "";
//
//    }

}
