package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Role;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/addexhibitor")
public class AddExhibitorController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExhibitorStandService exhibitorStandService;

    @GetMapping
    public String getCreateStand(HttpServletRequest req, RedirectAttributes ra, HttpSession session) {

        if(!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("error_message", "Skrrt du er ikke logget inn");
            return "redirect:jurylogin";
        }if(LoginUtil.erBrukerInnlogget(session) && !req.getSession().getAttribute(("roleId")).equals(Role.EXHIBITOR)){
            if(req.getSession().getAttribute(("roleId")).equals(Role.EXHIBITOR)){
                return "redirect:exhibitormain";
            }
            if(req.getSession().getAttribute(("roleId")).equals(Role.SPECTATOR)){
                return "redirect:spectatormain";
            }
            if(req.getSession().getAttribute(("roleId")).equals(Role.JURY)){
                return "redirect:jurymain";
            }
            if(req.getSession().getAttribute(("roleId")).equals(Role.ADMIN)){
                return "redirect:adminmain";
            }

        }

        return "AddExhibitorView";

    }

    @PostMapping
    public String postAddExhibitorToStand(@RequestParam String email, HttpServletRequest req, RedirectAttributes ra, HttpSession session) {

        if(!LoginUtil.erBrukerInnlogget(session)){
            ra.addFlashAttribute("error_message", "Skrrt du er ikke logget inn");
            return "redirect:jurylogin";
        }if(LoginUtil.erBrukerInnlogget(session) && !req.getSession().getAttribute(("userId")).equals(Role.EXHIBITOR)){
            if(req.getSession().getAttribute(("userId")).equals(Role.EXHIBITOR)){
                return "redirect:exhibitormain";
            }
            if(req.getSession().getAttribute(("userId")).equals(Role.SPECTATOR)){
                return "redirect:spectatormain";
            }
            if(req.getSession().getAttribute(("userId")).equals(Role.JURY)){
                return "redirect:jurymain";
            }
            if(req.getSession().getAttribute(("userId")).equals(Role.ADMIN)){
                return "redirect:adminmain";
            }

        }
       
        
        User current = userService.findByMail((String) req.getSession().getAttribute("username"));
        User addUser = userService.findByMail(email);

        if (addUser == null) {
            ra.addFlashAttribute("redirectMessage", "User does not exist");
            return "redirect:/addexhibitor";
        } else if (addUser.equals(current)) {
            ra.addFlashAttribute("redirectMessage", "Can't add yourself");

        }
        /* Integer standId = exhibitorStandService.findStandIdByUserId(current.getId());
        exhibitorStandService.addExhbitorStand(addUser.getId(), standId); */

        return "redirect:/viewstand";
    }

}
