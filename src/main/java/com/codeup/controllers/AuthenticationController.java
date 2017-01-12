package com.codeup.controllers;

import com.codeup.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

//    @PostMapping("/login")
//    public String login() {
//
//    }

//    @GetMapping("/register")
//    public String showRegisterForm(Model m) {
//        m.addAttribute("user", new User());
//        return "users/register";
//    }
//
//    @PostMapping("/register")
//    public String createUser(
//            @Valid User user,
//            Errors validation,
//            Model model
//    ) {
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("user", user);
//            return "/register";
//        }
//        // something should be happening to create a new user? right?
//        return "redirect:/login";
//    }
}