package com.kodilla.good.patterns.challenges.exercise2;

import com.kodilla.good.patterns.challenges.exercise2.service.*;

public class Main {
    public static void main(String[] args) {
        OrderServiceRetriever orderServiceRetriever = new OrderServiceRetriever();
        OrderRequest orderRequest = orderServiceRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new OrderProduct());
        productOrderService.process(orderRequest);
    }

}
