package com.kodilla.good.patterns.challenges.exercise4.orders;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;

public class OrderInformation {
    public void inform(OrderRequestDto orderRequestDto){
        if (orderRequestDto.isOrderPossible()) {
            System.out.println("Zamówienie zostanie zrealizowane przez firmę " + orderRequestDto.getOrderRequest().getSupplier().getCompanyName()
                        + ". Komentarz od sprzedawcy: \"" + orderRequestDto.getText() + "\"");
        } else {
            System.out.println("Zamówienie NIE zostanie zrealizowane przez firmę " + orderRequestDto.getOrderRequest().getSupplier().getCompanyName()
                    + ". Komentarz od sprzedawcy: \"" + orderRequestDto.getText() + "\"");
        }
    }
}
