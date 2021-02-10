package com.kodilla.good.patterns.challenges.exercise4;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.orders.*;
import com.kodilla.good.patterns.challenges.exercise4.shops.Supplier;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        List<OrderRequest> orderRequests = orderRequestRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor();

        for (OrderRequest orderRequest : orderRequests){
            orderProcessor.process(orderRequest);
        }
    }
}
