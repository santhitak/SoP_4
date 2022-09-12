package com.example.lab04service.views.MathAPI;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route("index")
public class MathView extends VerticalLayout {

    TextField n1 = new TextField("Number 1");
    TextField n2 = new TextField("Number 2");
    TextField n3 = new TextField("Answer");

    public MathView(){
        Div container = new Div();
        container.setWidth("40vw");
        container.setHeight("100%");

        FormLayout calculator = new FormLayout();

        FormLayout btnForm = new FormLayout();
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMulti = new Button("x");
        Button btnDivide = new Button("/");
        Button btnMod = new Button("Mod");
        Button btnMax = new Button("Max");

        btnPlus.addClickListener(e -> Result("plus"));
        btnMinus.addClickListener(e -> Result("minus"));
        btnMulti.addClickListener(e -> Result("multi"));
        btnDivide.addClickListener(e -> Result("divide"));
        btnMod.addClickListener(e -> Result("mod"));
        btnMax.addClickListener(e -> Result("max"));

        btnForm.add(btnPlus, btnMinus, btnMinus, btnMulti, btnDivide, btnMod, btnMax);
        calculator.add(n1, n2, new Text("Operators"), btnForm, n3);

        calculator.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 2),
                new FormLayout.ResponsiveStep("500px", 1)
        );

        calculator.setColspan(btnForm, 2);

        container.add(calculator);
        add(container);

        setSizeFull();
        setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.START);
    }

    public void Result(String type){
        int x = Integer.parseInt(n1.getValue());
        int y = Integer.parseInt(n2.getValue());

        String out = WebClient.create()
                .get()
                .uri("http://localhost:8080/" + type + "/"+ x +"/"+ y )
                .retrieve()
                .bodyToMono(String.class)
                .block();

        n3.setValue(out);
    }
}
