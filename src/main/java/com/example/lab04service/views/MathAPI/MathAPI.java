package com.example.lab04service.views.MathAPI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

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

    public double myPlus(double n1, double n2){
        return n1+n2;
    }
}
