package com.example.lab04service.views.Change;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {

    @RequestMapping("/getChange/{coin}")
    public Change getChange(@PathVariable("coin") int coin){
        Change pocket = new Change();
        pocket.setB1000(coin/1000);
        coin %= 1000;
        pocket.setB500(coin/500);
        coin %= 500;
        pocket.setB100(coin/100);
        coin %= 100;
        pocket.setB20(coin/20);
        coin %= 20;
        pocket.setB10(coin/10);
        coin %= 10;
        pocket.setB5(coin/5);
        coin %= 5;
        pocket.setB1(coin);

        return pocket;
    }
}
