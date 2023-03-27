package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/viewstand")
public class ViewStandController {

    @Autowired
    public StandService standService;

    @Autowired
    public ExhibitorStandService exhibitorStandService;

    @Autowired
    public UserService userService;

    @GetMapping
    public String getViewStand(Model model, HttpServletRequest req){

        if(req.getSession().getAttribute("stand") == null){
            return "redirect:/createstand";
        }
        Integer userId = userService.findByMail((String)req.getSession().getAttribute("username")).getId();
        Integer standId = exhibitorStandService.findStandByUserId(userId);
        model.addAttribute("stand", standService.getStandbyStandId(standId));
        return "ViewStandView";
    }

//    @PostMapping
//    public String postViewStand(HttpServletRequest req){
//        return "";
//
//    }

}
