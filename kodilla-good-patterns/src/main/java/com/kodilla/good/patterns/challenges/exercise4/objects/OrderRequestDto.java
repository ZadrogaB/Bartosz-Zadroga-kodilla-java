package com.kodilla.good.patterns.challenges.exercise4.objects;

public class OrderRequestDto {
    private OrderRequest orderRequest;
    private boolean isOrderPossible;
    private String text;

    public OrderRequestDto(OrderRequest orderRequest, boolean isOrderPossible, String text) {
        this.orderRequest = orderRequest;
        this.isOrderPossible = isOrderPossible;
        this.text = text;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isOrderPossible() {
        return isOrderPossible;
    }

    public String getText() {
        return text;
    }
}
