package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jessedavila on 1/4/17.
 */
@Controller
public class HelloController {
    @GetMapping("/myresume")
    public String resume() {
        return "resume";
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }


}
