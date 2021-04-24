package com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.meat;

import com.kodilla.patterns2.decorator.taxiportal.pizza.PizzaOrder;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.AbstractPizzaDecorator;

import java.math.BigDecimal;

public class HamDecorator extends AbstractPizzaDecorator {
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }

    public HamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
}
