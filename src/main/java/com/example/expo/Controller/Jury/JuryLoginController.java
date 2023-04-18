package com.example.expo.Controller.Jury;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.expo.Model.Role;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;

@Controller
@RequestMapping("/jurylogin")
public class JuryLoginController {


    @Autowired
    private UserService userService;
    
    @GetMapping
    public String getjurylogin() {
        return "JuryLoginView";
    }

    @PostMapping
    public String postLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest req, RedirectAttributes ra, HttpSession session) {
        if (!userService.findUserByEmail(username)) {
            ra.addFlashAttribute("error_message", "User does not exist");
            return "redirect:/jurylogin";
        }
        if (!(userService.validateLogin(username, password))) {
            ra.addFlashAttribute("error_message", "Innlogging feilet");
            return "redirect:/jurylogin";
        } else {
            LoginUtil.loggInnBruker(req, Role.JURY.getRoleID());
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("userId", userService.findByMail(username).getId());
            req.getSession().setAttribute("roleId", Role.JURY);
            return "redirect:jurymain";
        }
    }
}
