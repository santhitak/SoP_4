package com.example.lab04service.views.MathAPI;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {

    @RequestMapping("/plus/{n1}/{n2}")
    public double myPlus(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        return n1+n2;
    }

    @RequestMapping("/minus/{n1}/{n2}")
    public double myMinus(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        return n1-n2;
    }

    @RequestMapping("/divide/{n1}/{n2}")
    public double myDivide(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        return n1/n2;
    }

    @RequestMapping("/multi/{n1}/{n2}")
    public double myMulti(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        return n1*n2;
    }

    @RequestMapping("/mod/{n1}/{n2}")
    public double myMod(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2){
        return n1%n2;
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public double myMax(@RequestParam("n1") Double n1, @RequestParam("n2") Double n2){
        return Math.max(n1, n2);
    }
}
