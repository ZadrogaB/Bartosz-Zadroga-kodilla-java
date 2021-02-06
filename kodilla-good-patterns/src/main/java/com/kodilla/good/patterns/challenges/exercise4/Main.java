package com.kodilla.good.patterns.challenges.exercise4;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.orders.InformationMail;
import com.kodilla.good.patterns.challenges.exercise4.orders.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.exercise4.orders.ProductOrderService;
import com.kodilla.good.patterns.challenges.exercise4.shops.ExtraFoodShop;

public class Main {
    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve(extraFoodShop);
        InformationMail informationMail = new InformationMail();
        ProductOrderService productOrderService = new ProductOrderService();

        extraFoodShop.process(orderRequest, informationMail, productOrderService);
    }

}
