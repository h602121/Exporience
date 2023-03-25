package com.example.expo.Controller;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.Vote;
import com.example.expo.Model.Service.ExpoPointsHandlerService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.VoteListByUser;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/myratings")
public class MyRatingController {

    @Autowired
    public ExpoPointsHandlerService handlerService;

    @Autowired
    public UserService userService;

    @GetMapping
    public String getMyRating(Model model, HttpSession session) {
        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:spectatorlogin";
        }
        User username = userService.findByMail((String) session.getAttribute("username"));
        List<VoteListByUser> voteListByUser = handlerService.getVotesByUserId(username.getId());
        model.addAttribute("votes", voteListByUser);
        return "MyRatingView";
    }

    @PostMapping
    public String postMyRating() {
        return "redirect:myratings";
    }
}
