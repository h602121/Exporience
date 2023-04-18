package com.example.expo.Controller.Admin;

import com.example.expo.Model.Role;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/createjury")
public class AddJuryController {

    @Value("${app.message.ugyldigfirstname}")
    private String UGYLDIG_FIRST_NAME;
    @Value("${app.message.ugyldiglastname}")
    private String UGYLDIG_LAST_NAME;
    @Value("${app.message.ugyldigepost}")
    private String UGYLDIG_EPOST;
    @Value("${app.message.ulikePassord}")
    private String ULIKE_PASSORD;
    @Value("${app.message.registrertBruker}")
    private String REGISTRERT_BRUKER;
    @Value("${app.message.bruktepost}")
    private String ALLEREDE_BRUKT_EPOST;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getCreateJury() {

        return "CreateJuryView";
    }

    @PostMapping
    public String postCreateJury(@RequestParam String phonenumber, @RequestParam String firstName,
                                      @RequestParam String lastName, @RequestParam
                                      String email, @RequestParam String password,
                                      @RequestParam String confirmPassword, HttpServletRequest request, RedirectAttributes ra) {

        if (!userService.gyldigFirstName(firstName)) {
            ra.addFlashAttribute("redirectMessage", UGYLDIG_FIRST_NAME);
            return "redirect:/createjury";
        }
        if (!userService.gyldigLastName(lastName)) {
            ra.addFlashAttribute("redirectMessage", UGYLDIG_LAST_NAME);

            return "redirect:/createjury";
        }
        if (!userService.gyldigePost(email)) {
            ra.addFlashAttribute("redirectMessage", UGYLDIG_EPOST);

            return "redirect:/createjury";
        }
        if (!password.equals(confirmPassword)) {
            ra.addFlashAttribute("redirectMessage", ULIKE_PASSORD);

            return "redirect:/createjury";
        }
        if (!userService.bruktTlf(phonenumber)) {
            ra.addFlashAttribute("redirectMessage", REGISTRERT_BRUKER);

            return "redirect:/createjury";
        }
        if (!userService.bruktEpost(email)) {
            ra.addFlashAttribute("redirectMessage", ALLEREDE_BRUKT_EPOST);

            return "redirect:/createjury";
        }


        String salt = PassordUtil.genererTilfeldigSalt();
        String passordMedSalt = PassordUtil.hashMedSalt(password, salt);

        userService.createSpectator(phonenumber, firstName, lastName, email, passordMedSalt, Role.JURY.getRoleID(), salt);
        return "redirect:/adminmain";

    }
}
