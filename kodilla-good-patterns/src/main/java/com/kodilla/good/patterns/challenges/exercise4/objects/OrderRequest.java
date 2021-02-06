package com.kodilla.good.patterns.challenges.exercise4.objects;

import com.kodilla.good.patterns.challenges.exercise4.shops.Supplier;

public class OrderRequest {
    private Supplier supplier;
    private Product product;
    private Client client;

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    public OrderRequest(Supplier supplier, Product product, Client client) {
        this.supplier = supplier;
        this.product = product;
        this.client = client;
    }
}
