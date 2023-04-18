package com.example.expo.Controller.Jury;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.Model.Service.UserVotesService;
import com.example.expo.util.LoginUtil;

@Controller
@RequestMapping("/jury-select-stand")
public class JuryStandListView {
    
    @Autowired
    StandService standService;

    @Autowired
    UserService userService;
    
    @Autowired
    UserVotesService userVotesService;

    @GetMapping
    public String getJurySelectStand(HttpSession session, RedirectAttributes ra, Model model, HttpServletRequest request) {
        if(!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("error_message", "Skrrt du er ikke logget inn");
            return "redirect:/jurylogin";
        }

        User tempUser=userService.findByMail((String) request.getSession().getAttribute("username"));
        List<Stand> stands=userVotesService.getStandsNotVotedOnByUser(tempUser.getId());
        
        model.addAttribute("stands", stands);

        return "StandListView";
    }

    @PostMapping
    public String postJurySelectStand(){
        return "redirect:/jurymain";
    }
}

