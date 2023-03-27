package com.example.expo.Controller.Exhibitor;

import com.example.expo.Model.Repo.StandRepo;
import com.example.expo.Model.Role;
import com.example.expo.Model.Service.ExhibitorStandService;
import com.example.expo.Model.Service.StandService;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.LoginUtil;
import com.example.expo.util.UserUtils;
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
@RequestMapping("/exhibitorlogin")
public class ExhibitorLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExhibitorStandService exhibitorStandService;

    @GetMapping
    public String getExhibitorLogin() {
        return "ExhibitorLoginView";
    }

    @PostMapping
    public String postLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest req, RedirectAttributes ra, HttpSession session) {


        if (!userService.findUserByEmail(username)) {
            ra.addFlashAttribute("error_message", "User does not exist");
            return "redirect:/exhibitorlogin";

        }
        if (!(userService.validateLogin(username, password))) {
            ra.addFlashAttribute("error_message", "Innlogging feilet");
            return "redirect:/exhibitorlogin";
        } else {
            LoginUtil.loggInnBruker(req, Role.EXHIBITOR.getRoleID());
            req.getSession().setAttribute("username", username);
            System.out.println("Tor Var hwer: " + exhibitorStandService.findStandByUserId(userService.findByMail(username).getId()));
            req.getSession().setAttribute("stand", exhibitorStandService.findStandByUserId(userService.findByMail(username).getId()));
            return "redirect:exhibitormain";

        }

    }
}
