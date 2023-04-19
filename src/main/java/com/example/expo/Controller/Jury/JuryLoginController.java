package com.example.expo.Controller.Jury;

import com.example.expo.Model.Role;
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
    public String postjurylogin(@RequestParam String username, @RequestParam String password, HttpServletRequest req, RedirectAttributes ra) {

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

            return "redirect:jurymain";
        }

    }
}
