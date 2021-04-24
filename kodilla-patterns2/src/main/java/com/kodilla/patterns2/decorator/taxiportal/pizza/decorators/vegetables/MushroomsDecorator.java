package com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.vegetables;

import com.kodilla.patterns2.decorator.taxiportal.pizza.PizzaOrder;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.AbstractPizzaDecorator;

import java.math.BigDecimal;

public class MushroomsDecorator extends AbstractPizzaDecorator {
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + mushrooms";
    }

    public MushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
}
