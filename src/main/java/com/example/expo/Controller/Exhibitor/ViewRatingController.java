package com.example.expo.Controller.Exhibitor;
import com.example.expo.Model.Role;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/viewratings")
public class ViewRatingController {

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
        Role role= (Role) req.getSession().getAttribute("roleId");

        if(role.equals(Role.ADMIN)){
            List<UserVotes> myVotedStands= userVotesService.findAllUserVotes();
            model.addAttribute("votes", myVotedStands);
            return "ViewRatingView";
        }
        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:spectatorlogin";
        }
        User username = userService.findByMail((String) session.getAttribute("username"));
        
        List <Stand> exhibitorStand = exhibitorStandService.findStandByUserId(username.getId());

        if(exhibitorStand == null || !standService.isActive(exhibitorStand)){
            return "redirect:/createstand";
        }
        List<UserVotes> myVotedStands= userVotesService.findMyStands(username.getId());

        
            model.addAttribute("votes", myVotedStands);
        
        
    
        
       

        
        return "ViewRatingView";
    }

//    @PostMapping
//    public String postViewStand(HttpServletRequest req){
//        return "";
//
//    }

}
