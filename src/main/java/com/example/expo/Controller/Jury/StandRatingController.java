package com.example.expo.Controller.Jury;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Stemmer;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.UserVotes;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.StemmerService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.Model.Service.UserVotesService;

@Controller
@RequestMapping("/stand/{id}")
public class StandRatingController {

    @Autowired
    private StandService standService;

    @Autowired
    private StemmerService stemmerService;

    @Autowired 
    private UserVotesService userVotesService;

    @Autowired
    private UserService userService;
    
    @GetMapping
    public String getStandRating(@PathVariable("id") Integer id, Model model) {
    Stand stand = standService.getStandbyStandId(id);
    if (stand == null) {
        return "redirect:/jurymain";
    }
    model.addAttribute("stand", stand);
    return "StandRatingView";
}
    @PostMapping
    public String postStandRating(@PathVariable("id") Integer id, HttpServletRequest request, HttpSession session) {
    Stand stand = standService.getStandbyStandId(id);
    if(stand==null){
        return "redirect:/jurymain";
    }
    int qrCode=stand.getQrCode();
    Integer presentation = Integer.parseInt(request.getParameter("presentation"));
    Integer panel = Integer.parseInt(request.getParameter("panel"));
    Integer content = Integer.parseInt(request.getParameter("content"));
    Integer interaction = Integer.parseInt(request.getParameter("interaction"));
    Integer total=(presentation+panel+content+interaction)/4;

    Stemmer tempStemmer = stemmerService.findByStandId(stand);
    if (tempStemmer == null) {
        Stemmer stemmer = new Stemmer(presentation, panel, content, interaction);
        stemmer.setStand(stand);
        stemmerService.save(stemmer);
        User tempUser=userService.findByMail((String) request.getSession().getAttribute("username"));
        
        UserVotes tempUserVotes=new UserVotes(tempUser, stand, presentation, panel, content, interaction, total);
        userVotesService.save(tempUserVotes);
        
    } else {
        User tempUser=userService.findByMail((String) request.getSession().getAttribute("username"));
        stemmerService.updateStemmer(presentation, panel, content, interaction, tempStemmer);
        
        
        UserVotes tempUserVotes=new UserVotes(tempUser, stand, presentation, panel, content, interaction, total);
        userVotesService.save(tempUserVotes);
        


    }

    

    return "redirect:/jurymain";
}

}

