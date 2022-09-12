package com.example.lab04service.views.Change;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route("cashier")
public class CashierView extends VerticalLayout {

    TextField coin = new TextField();
    TextField B1000 = new TextField(), B500 = new TextField(),
            B100 = new TextField(), B20 = new TextField(),
            B10 = new TextField(), B5 = new TextField(), B1 = new TextField();

    public CashierView(){
        coin.setLabel("Money");
        Div dollarPrefix = new Div();
        dollarPrefix.setText("$");
        coin.setPrefixComponent(dollarPrefix);

        Div d1000 = new Div();
        d1000.setText("$1000:");
        B1000.setPrefixComponent(d1000);

        Div d500 = new Div();
        d500.setText("$500:");
        B500.setPrefixComponent(d500);

        Div d100 = new Div();
        d100.setText("$100:");
        B100.setPrefixComponent(d100);

        Div d20 = new Div();
        d20.setText("$20:");
        B20.setPrefixComponent(d20);

        Div d10 = new Div();
        d10.setText("$10:");
        B10.setPrefixComponent(d10);

        Div d5 = new Div();
        d5.setText("$5:");
        B5.setPrefixComponent(d5);

        Div d1 = new Div();
        d1.setText("$10:");
        B1.setPrefixComponent(d1);

        Div container = new Div();
        container.setWidth("40vw");
        container.setHeight("100%");

        FormLayout cashier = new FormLayout();
        Button checkout = new Button("Check out");

        checkout.addClickListener(e -> {
            int x = Integer.parseInt(coin.getValue());

            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/" + x )
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            B1000.setValue(out.getB1000()+"");
            B500.setValue(out.getB500()+"");
            B100.setValue(out.getB100()+"");
            B20.setValue(out.getB20()+"");
            B10.setValue(out.getB10()+"");
            B5.setValue(out.getB5()+"");
            B1.setValue(out.getB1()+"");
        });

        cashier.add(coin, checkout, B1000, B500, B100, B20, B10, B5, B1);

        cashier.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 2),
                new FormLayout.ResponsiveStep("500px", 1)
        );

        container.add(cashier);
        add(container);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
    }
}
