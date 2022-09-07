package com.stanley.CodeFellowship.Controllers;

import com.stanley.CodeFellowship.Models.Youser;
import com.stanley.CodeFellowship.Repositories.YouserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import org.springframework.ui.Model;

@Controller
public class YouserController {
    @Autowired
    YouserRepo youserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String getHome(Principal p, Model m){
        if(p != null){
            String username = p.getName();

            m.addAttribute("username", username);
        }
        return "index.html";
    }
}
