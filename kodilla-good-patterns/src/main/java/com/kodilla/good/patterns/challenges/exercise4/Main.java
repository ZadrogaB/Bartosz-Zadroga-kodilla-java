package com.kodilla.good.patterns.challenges.exercise4;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.orders.*;
import com.kodilla.good.patterns.challenges.exercise4.shops.Supplier;

public class Main {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor();

        orderProcessor.process("ExtraFoodShop", orderRequest);
        orderProcessor.process("GlutenFreeShop", orderRequest);
        orderProcessor.process("HealthyShop", orderRequest);
    }
}
