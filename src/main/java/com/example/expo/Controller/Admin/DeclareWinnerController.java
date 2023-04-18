package com.example.expo.Controller.Admin;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.Winner;
import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.Model.Service.WinnerTimeService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/declarewinner")
public class DeclareWinnerController {
    
    @Autowired
    WinnerTimeService winnerTimeService;
    

    @GetMapping 
    public String getDeclareWinner(){

        return "DeclareWinnerView";
    }

    @PostMapping
    public String declareWinner(@RequestParam("date") String date, @RequestParam("time") String time, Model model) {

       

        LocalDateTime dateTime = LocalDateTime.parse(date + "T" + time); // parse the date and time strings into a LocalDateTime object
        LocalDate winnerDate = dateTime.toLocalDate();
        LocalTime winnerTime=dateTime.toLocalTime();
        Winner declareWinner = new Winner(winnerDate, winnerTime); // create a new WinnerTime object with the date and time
        winnerTimeService.saveWinnerTime(declareWinner);
        return "redirect:/adminmain";
    }
    

}
