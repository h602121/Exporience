package com.example.expo.Controller.Admin;

import com.example.expo.Model.Role;
import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Winner;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.StemmerService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.Model.Service.WinnerTimeService;
import com.example.expo.util.LoginUtil;
import com.example.expo.util.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/seewinner")
public class SeeWinnerController {
    
    @Autowired
    public WinnerTimeService winnerTimeService;

    @Autowired
    public StandService standService;
    
    @Autowired
    public UserService userService;

    @Autowired
    public StemmerService stemmerService;

    @GetMapping
    public String getWinner(HttpSession session, HttpServletRequest request, RedirectAttributes ra, Model model){
        List<Stand> allWinners = winnerTimeService.getAllWinner();
        if(!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("error_message", "Skrrt du er ikke logget inn");
            return "redirect:jurylogin";
        }
        
    
        // Check the database for an active WinnerTime entity
        Winner winnerTime = winnerTimeService.findActiveWinnerTime();
    
        if (winnerTime == null) {
            // No active winner time found, return the view without adding any model attributes
            ra.addFlashAttribute("error_message", "Time of winner-declartion not yet selected");
            model.addAttribute("allWinners", allWinners);
            return "SeeWinnerView";
        }
    
        // Get the current date and time from the system clock
        LocalDateTime now = LocalDateTime.now();
    
        // Check if the winner time has been reached
        LocalDateTime winnerDateTime = LocalDateTime.of(winnerTime.getWinnerDate(), winnerTime.getWinnerTime());
        if (now.isBefore(winnerDateTime)) {
            ra.addFlashAttribute("error_message", "Winner not declared yet");
            model.addAttribute("allWinners", allWinners);
            return "SeeWinnerView";
        }
    
        // Declare winner
        Stand winner = stemmerService.declareWinner();
        
        // Update all stands to be inactive
        standService.setAllStandsInactive();
    
        // Update the winner_time entity to be inactive
        winnerTime.setActive(false);
        winnerTimeService.saveWinnerTime(winnerTime);
    
        // Add the winner date, winner time, and stand name to the model
        

        model.addAttribute("winner", winnerTime);
        
        model.addAttribute("allWinners", allWinners);
        
        // Add the winning stand to the winner_time entity's qr_code column
        winnerTime.setStand(winner);
        winnerTimeService.saveWinnerTime(winnerTime);
    
        return "SeeWinnerView";
    }
    

    /* @GetMapping
    public String postWinner(){

        return "SeeWinnerView";

    } */
}
