package com.kodilla.good.patterns.challenges.exercise4;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.Supplier;
import com.kodilla.good.patterns.challenges.exercise4.orders.*;

public class Main {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor();
        Supplier supplier = orderRequest.getSupplierList().getSupplierFromList("ExtraFoodShop");

        OrderRequestDto orderRequestDto = orderProcessor.process(supplier, orderRequest);
        OrderInformation orderInformation = new OrderInformation();
        orderInformation.information(orderRequestDto);
    }
}
