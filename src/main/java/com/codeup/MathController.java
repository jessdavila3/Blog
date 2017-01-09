package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jessedavila on 1/4/17.
 */
@Controller
public class MathController {


    @RequestMapping(path = "/add/{num}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int num,@PathVariable int num2) {
        return num + " plus " + num2 + " is " + (num+num2);
    }

    @RequestMapping(path = "/subtract/{num}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num, @PathVariable int num2) {
        return num + " minus " + num2 + " is " + (num-num2);
    }

    @RequestMapping(path = "/multiply/{num}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num, @PathVariable int num2) {
        return num + " times " + num2 + " is " + (num*num2);
    }

    @RequestMapping(path = "/divide/{num}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num, @PathVariable int num2) {
        return num + " divided by " + num2 + " is " + (num/num2);
    }

    @RequestMapping(path = "/product", method = RequestMethod.GET)
    @ResponseBody
    public String showProduct(@PathVariable String name, @PathVariable String Price) {
        return "hey";
    }
}