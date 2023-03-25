package com.example.expo.Controller;

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

@Controller
@RequestMapping("/exhibitorlogin")
public class ExhibitorLoginController {
    
    @GetMapping
    public String getExhibitorLogin() {
        return "ExhibitorLoginView";
    }

    @PostMapping
    public String postExhibitorLogin(){
        return "exhibitorlogin";
    }
}
