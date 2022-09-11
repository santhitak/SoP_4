package com.example.lab04service.views.MathAPI;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Route("index")
public class MathAPI extends VerticalLayout {

    public MathAPI(){
        Div container = new Div();
        container.setWidth("40vw");
        container.setHeight("100%");

        FormLayout calculator = new FormLayout();
        NumberField n1 = new NumberField("Number 1");
        NumberField n2 = new NumberField("Number 2");
        NumberField n3 = new NumberField("Answer");

        FormLayout btnForm = new FormLayout();
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMulti = new Button("x");
        Button btnDivide = new Button("/");
        Button btnMod = new Button("Mod");
        Button btnMax = new Button("Max");

        btnPlus.addClickListener(e -> {this.myPlus(n1.getValue(), n2.getValue());});
        btnMinus.addClickListener(e -> {this.myMinus(n1.getValue(), n2.getValue());});
        btnMulti.addClickListener(e -> {this.myMulti(n1.getValue(), n2.getValue());});
        btnDivide.addClickListener(e -> {this.myDivide(n1.getValue(), n2.getValue());});
        btnMod.addClickListener(e -> {this.myMod(n1.getValue(), n2.getValue());});
        btnMax.addClickListener(e -> {this.myMax(n1.getValue(), n2.getValue());});

        btnForm.add(btnPlus, btnMinus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);

        calculator.add(n1);
        calculator.add(n2);
        calculator.add(new Text("Operators"));
        calculator.add(btnForm);
        calculator.add(n3);

        calculator.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 2),
                new FormLayout.ResponsiveStep("500px", 1)
        );

        calculator.setColspan(btnForm, 2);

        container.add(calculator);
        add(container);

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

    @RequestMapping("/max/{n1}/{n2}")
    public double myMax(@PathVariable Double n1, @PathVariable Double n2){
        return Math.max(n1, n2);
    }
}
