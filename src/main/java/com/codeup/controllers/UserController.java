package com.codeup.controllers;

import com.codeup.User;
import com.codeup.UserWithRoles;
import com.codeup.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by jessedavila on 1/11/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public Users usersDao;

    @GetMapping("/create")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/create")
    public String createUser(
            @ModelAttribute User user
            //Errors validation,
            //Model model
    ) {
//        if (validation.hasErrors()) {
//            model.addAttribute("errors", validation);
//            model.addAttribute("user", user);
//            return "user/create";
//        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDao.save(user);
        return "redirect:/posts";
    }


}