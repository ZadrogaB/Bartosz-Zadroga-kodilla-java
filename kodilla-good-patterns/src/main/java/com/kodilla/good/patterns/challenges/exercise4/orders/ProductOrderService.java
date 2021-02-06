package com.kodilla.good.patterns.challenges.exercise4.orders;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;

public class ProductOrderService implements OrderService {
    public boolean order(final OrderRequest orderRequest){
        System.out.println("Order for: " + orderRequest.getClient().getName() + orderRequest.getClient().getSurname()
                + ", from: " + orderRequest.getSupplier().getCompanyName()
                + ". Ordered product " + orderRequest.getProduct().getProductName()
                + " in amount: " + orderRequest.getProduct().getNumberOfProducts()
                + ". Price: " +Double.valueOf(orderRequest.getProduct().getNumberOfProducts()) *
                orderRequest.getProduct().getPrice());

        return true;
    }
}
