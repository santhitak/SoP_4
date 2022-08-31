package com.example.lab04service.views.MathAPI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Route("index")
public class MathAPI extends VerticalLayout {
    private TextField n1, n2, n3;
    private Button btnPlus, btnMinus, btn;

    public MathAPI(){
        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        n3 = new TextField("Answer");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btn = new Button("Show names");
        add(n1, n2, n3, btnPlus, btnMinus, btn);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
    }

    @RequestMapping("/plus/{n1}/{n2}")
    public double myPlus(@PathVariable Double n1, @PathVariable Double n2){
        return n1+n2;
    }

    @RequestMapping("/minus/{n1}/{n2}")
    public double myMinus(@PathVariable Double n1, @PathVariable Double n2){
        return n1-n2;
    }

    @RequestMapping("/divide/{n1}/{n2}")
    public double myDivide(@PathVariable Double n1, @PathVariable Double n2){
        return n1/n2;
    }

    @RequestMapping("/multi/{n1}/{n2}")
    public double myMulti(@PathVariable Double n1, @PathVariable Double n2){
        return n1*n2;
    }

    @RequestMapping("/mod/{n1}/{n2}")
    public double myMod(@PathVariable Double n1, @PathVariable Double n2){
        return n1%n2;
    }
}
