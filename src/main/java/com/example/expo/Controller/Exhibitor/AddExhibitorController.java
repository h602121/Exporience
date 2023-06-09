package com.example.expo.Controller.Exhibitor;

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
    public String getCreateStand(HttpSession session) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            return "redirect:exhibitorlogin";
        }

        return "AddExhibitorView";

    }

    @PostMapping
    public String postAddExhibitorToStand(@RequestParam String email, HttpServletRequest req, RedirectAttributes ra) {

        User current = userService.findByMail((String) req.getSession().getAttribute("username"));
        User addUser = userService.findByMail(email);

        if (addUser == null) {
            ra.addFlashAttribute("redirectMessage", "User does not exist");
            return "redirect:/addexhibitor";
        } else if (addUser.equals(current)) {
            ra.addFlashAttribute("redirectMessage", "Can't add yourself");

        }
        Integer standId = exhibitorStandService.findStandByUserId(current.getId());
        exhibitorStandService.addExhbitorStand(addUser.getId(), standId);

        return "redirect:/viewstand";
    }

}
