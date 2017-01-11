package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model m) {
        m.addAttribute("user", new User());
        return "users/register";
    }
}