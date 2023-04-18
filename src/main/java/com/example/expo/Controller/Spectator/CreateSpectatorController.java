package com.example.expo.Controller.Spectator;

import com.example.expo.Model.Role;
import com.example.expo.Model.Service.UserService;
import com.example.expo.util.PassordUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;




@Controller
@RequestMapping("/createspectator")
public class CreateSpectatorController {

    @Value("${app.message.ugyldigfirstname}")   private String UGYLDIG_FIRST_NAME;
    @Value("${app.message.ugyldiglastname}")   private String UGYLDIG_LAST_NAME;
    @Value("${app.message.ugyldigepost}")   private String UGYLDIG_EPOST;
    @Value("${app.message.ulikePassord}")   private String ULIKE_PASSORD;
    @Value("${app.message.registrertBruker}")   private String REGISTRERT_BRUKER;
    @Value("${app.message.bruktepost}")   private String ALLEREDE_BRUKT_EPOST;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getCreateSpectator(HttpSession session){

        return "CreateSpectatorView";
    }

    @PostMapping
    public String postCreateSpectator(@RequestParam String phonenumber,@RequestParam String firstName,
                                      @RequestParam String lastName,@RequestParam
                                      String email,@RequestParam String password,
                                      @RequestParam String confirmPassword, HttpServletRequest request, RedirectAttributes ra){





        if(!userService.gyldigFirstName(firstName)){
            ra.addFlashAttribute("redirectMessage", UGYLDIG_FIRST_NAME);
            return "redirect:/createspectator";
        }
        if(!userService.gyldigLastName(lastName)){
            ra.addFlashAttribute("redirectMessage", UGYLDIG_LAST_NAME);
            return "redirect:/createspectator";
        }
        if(!userService.gyldigePost(email)){
            ra.addFlashAttribute("redirectMessage", UGYLDIG_EPOST);
            return "redirect:/createspectator";
        }
        if(!password.equals(confirmPassword)){
            ra.addFlashAttribute("redirectMessage", ULIKE_PASSORD);
            return "redirect:/createspectator";
        }
        if(!userService.bruktTlf(phonenumber)){
            ra.addFlashAttribute("redirectMessage", REGISTRERT_BRUKER);
            return "redirect:/createspectator";
        }
        if(!userService.bruktEpost(email)){
            ra.addFlashAttribute("redirectMessage", ALLEREDE_BRUKT_EPOST);
            return "redirect:/createspectator";
        }


        String salt=PassordUtil.genererTilfeldigSalt();
        String passordMedSalt=PassordUtil.hashMedSalt(password, salt);

        userService.createSpectator(phonenumber, firstName, lastName, email, passordMedSalt, Role.SPECTATOR.getRoleID(), salt);
        return "redirect:/spectatormain";

    }
}


//package com.example.expo.Controller;
//
//import com.example.expo.Model.Role;
//import com.example.expo.Model.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequestMapping("/createspectator")
//public class CreateSpectatorController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public String getCreateSpectator(){
//        return "CreateSpectatorView";
//    }
//
//    @PostMapping
//    public String postCreateSpectator(@RequestParam String phonenumber, @RequestParam String firstName,
//                                      @RequestParam String lastName, @RequestParam
//                                      String email, @RequestParam String password,
//                                      @RequestParam String confirmPassword, RedirectAttributes ra){
//
//
//        if (password.equals(confirmPassword)){
//        userService.createSpectator(phonenumber,firstName,lastName,email,password, Role.SPECTATOR.getRoleID());
//        return "redirect:/spectatormain";
//        }
//
//        return "redirect:/createspectator";
//    }
//}
