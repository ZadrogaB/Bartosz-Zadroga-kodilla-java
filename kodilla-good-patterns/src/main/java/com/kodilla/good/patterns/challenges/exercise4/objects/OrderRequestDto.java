package com.kodilla.good.patterns.challenges.exercise4.objects;

public class OrderRequestDto {
    private OrderRequest orderRequest;
    private boolean isOrderPossible;
    private Supplier supplier;

    public OrderRequestDto(OrderRequest orderRequest, boolean isOrderPossible, Supplier supplier) {
        this.orderRequest = orderRequest;
        this.isOrderPossible = isOrderPossible;
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isOrderPossible() {
        return isOrderPossible;
    }
}
