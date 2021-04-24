package com.kodilla.patterns2.decorator.taxiportal.pizza.decorators;

import com.kodilla.patterns2.decorator.taxiportal.pizza.PizzaOrder;

import java.math.BigDecimal;

public abstract class AbstractPizzaDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    public AbstractPizzaDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }
}
