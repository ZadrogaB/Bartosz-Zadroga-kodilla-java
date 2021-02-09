package com.kodilla.good.patterns.challenges.exercise4.orders;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;

public class OrderInformation {
    public void information(OrderRequestDto orderRequestDto){
        if(orderRequestDto.isOrderPossible()) {
            System.out.println("Udało się zrealizować zamówienie w sklepie " + orderRequestDto.getSupplier().getCompanyName() + " dla " + orderRequestDto.getOrderRequest().getClient().getName() + " "
                    + orderRequestDto.getOrderRequest().getClient().getSurname() + ". Zamówienie: " + orderRequestDto.getOrderRequest().getProduct().getProductName()
                    + " x " + orderRequestDto.getOrderRequest().getProduct().getNumberOfProducts() + ". Cena: " + orderRequestDto.getOrderRequest().getProduct().getNumberOfProducts()
                    * orderRequestDto.getOrderRequest().getProduct().getPrice());
        } else {
            System.out.println("Nie udało się zrealizować zamówienia. " + orderRequestDto.getSupplier().getCompanyName() + " ma tylko "
                    + orderRequestDto.getSupplier().getNumberOfProduct(orderRequestDto.getOrderRequest().getProduct())
                    + " " + orderRequestDto.getOrderRequest().getProduct().getProductName());
        }
    }
}
