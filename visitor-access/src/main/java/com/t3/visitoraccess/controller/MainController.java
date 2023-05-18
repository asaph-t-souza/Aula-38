package com.t3.visitoraccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.t3.visitoraccess.entity.SecurityUser;
import com.t3.visitoraccess.entity.User;
import com.t3.visitoraccess.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userPage(){
        return "user";
    }
    
}
