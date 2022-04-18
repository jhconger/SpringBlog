package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNum(@PathVariable int num1, @PathVariable int num2){
        return "If you add " + num1 + " and " + num2 + " you'll get " +(num1 + num2) + ".";
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtractNum(@PathVariable int num1, @PathVariable int num2){
        return "If you subtract " + num1 + " from " + num2 + " you'll get " + (num2 - num1) + ".";
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNums(@PathVariable int num1, @PathVariable int num2){
        return "If you multiply " + num1 + " and " + num2 + " you'll get " + (num1 * num2) + ".";
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNums(@PathVariable int num1, @PathVariable int num2){
        return "If you divided " + num1 + " by " + num2 + " you'll get " + (num1/num2) + ".";
    }
}