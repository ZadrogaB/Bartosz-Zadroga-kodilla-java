package com.kodilla.patterns2.decorator.taxiportal.pizza;

import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.another.AnchoisDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.another.CheeseDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.another.PineappleDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.meat.BeaconDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.meat.ChickenDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.meat.HamDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.vegetables.CornDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.vegetables.MushroomsDecorator;
import com.kodilla.patterns2.decorator.taxiportal.pizza.decorators.vegetables.OnionDecorator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost(){
        //Given
        PizzaOrder order = new BasicPizza();
        //When
        BigDecimal calculatedCost = order.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription(){
        //Given
        PizzaOrder order = new BasicPizza();
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void testPizzaWithAllOrderGetCost(){
        //Given
        PizzaOrder order = new BasicPizza();
        order = new AnchoisDecorator(order);
        order = new CheeseDecorator(order);
        order = new PineappleDecorator(order);
        order = new BeaconDecorator(order);
        order = new ChickenDecorator(order);
        order = new HamDecorator(order);
        order = new CornDecorator(order);
        order = new MushroomsDecorator(order);
        order = new OnionDecorator(order);
        //When
        BigDecimal calculatedCost = order.getCost();
        //Then
        assertEquals(new BigDecimal(39), calculatedCost);
    }

    @Test
    public void testPizzaWithAllGetDescription(){
        //Given
        PizzaOrder order = new BasicPizza();
        order = new AnchoisDecorator(order);
        order = new CheeseDecorator(order);
        order = new PineappleDecorator(order);
        order = new BeaconDecorator(order);
        order = new ChickenDecorator(order);
        order = new HamDecorator(order);
        order = new CornDecorator(order);
        order = new MushroomsDecorator(order);
        order = new OnionDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese + " +
                "anchois + extra cheese + pineapple + beacon + " +
                "chicken + ham + corn + mushrooms + onion", description);
    }

}