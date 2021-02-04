package com.kodilla.good.patterns.challenges.exercise2;

import com.kodilla.good.patterns.challenges.exercise2.interfaces_and_implementing_Classes.MailService;
import com.kodilla.good.patterns.challenges.exercise2.interfaces_and_implementing_Classes.OrderProduct;
import com.kodilla.good.patterns.challenges.exercise2.orders.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise2.orders.OrderServiceRetriever;
import com.kodilla.good.patterns.challenges.exercise2.orders.ProductOrderService;

public class Main {
    public static void main(String[] args) {
        OrderServiceRetriever orderServiceRetriever = new OrderServiceRetriever();
        OrderRequest orderRequest = orderServiceRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new OrderProduct());
        productOrderService.process(orderRequest);
    }

}
