package com.codeup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String welcome() {
        return "dice-page";
    }

    @RequestMapping("roll-dice/{n}")
    @ResponseBody
    public String guess(@PathVariable int n) {
        int random = (int )(Math.random() * 6 + 1);
        if (n == random) {
            return "<h2>You got it</h2>";
        } else {
            return "<h2>Your number was " + n + ". The die rolled a " + random+".</h2>";
        }
    }
}