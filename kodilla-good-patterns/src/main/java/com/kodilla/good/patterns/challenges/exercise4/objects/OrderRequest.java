package com.kodilla.good.patterns.challenges.exercise4.objects;


import com.kodilla.good.patterns.challenges.exercise4.shops.Supplier;

public class OrderRequest {
    private Product product;
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public OrderRequest(Product product, Supplier supplier) {
        this.product = product;
        this.supplier = supplier;
    }

    public Product getProduct() {
        return product;
    }


}
