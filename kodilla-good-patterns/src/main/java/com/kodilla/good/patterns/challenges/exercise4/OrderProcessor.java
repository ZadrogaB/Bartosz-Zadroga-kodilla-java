package com.kodilla.good.patterns.challenges.exercise4;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.orders.InformationService;
import com.kodilla.good.patterns.challenges.exercise4.orders.OrderService;

public class OrderProcessor {

    public static void process(final OrderRequest orderRequest,
                        final InformationService informationService,
                        final OrderService orderService) {
        if(orderRequest.getProduct().getNumberOfProducts() <
                orderRequest.getSupplier().getNumberOfProduct(orderRequest.getProduct(), orderRequest.getSupplier().getProductList())) {
            informationService.inform(orderRequest.getClient());
            orderService.order(orderRequest);
            orderRequest.getSupplier().removeProductFromList(orderRequest.getProduct(), orderRequest.getSupplier().getProductList());
        } else {
            System.out.println("Sprzedawca ma mniej produktu niż zamawiasz! Zamówienie nieudane.");
        }
    }
}
