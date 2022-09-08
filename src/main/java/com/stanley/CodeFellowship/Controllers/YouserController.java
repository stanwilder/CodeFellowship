package com.stanley.CodeFellowship.Controllers;

import com.stanley.CodeFellowship.Models.Youser;
import com.stanley.CodeFellowship.Repositories.YouserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }
    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, int dateOfBirth, String bio) throws ServletException
    {
        String hashedPassword = passwordEncoder.encode(password);
        Youser newUser = new Youser(username, hashedPassword, firstName,
                lastName,
                dateOfBirth, bio);
        youserRepo.save(newUser);
        request.login(username, password);
        return new RedirectView("/");
    }
}
