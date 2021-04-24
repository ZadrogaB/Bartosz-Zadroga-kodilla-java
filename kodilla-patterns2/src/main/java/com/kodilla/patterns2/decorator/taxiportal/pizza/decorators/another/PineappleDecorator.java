package com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.another;

import com.kodilla.patterns2.decorator.taxiportal.pizza.PizzaOrder;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.AbstractPizzaDecorator;

import java.math.BigDecimal;

public class PineappleDecorator extends AbstractPizzaDecorator {

    public PineappleDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + pineapple";
    }
}
