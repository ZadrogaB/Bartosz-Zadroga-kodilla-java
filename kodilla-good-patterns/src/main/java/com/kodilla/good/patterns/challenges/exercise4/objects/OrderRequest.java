package com.kodilla.good.patterns.challenges.exercise4.objects;

public class OrderRequest {
    private Product product;
    private SupplierList supplierList;

    public OrderRequest(Product product, SupplierList supplierList) {
        this.product = product;
        this.supplierList = supplierList;
    }

    public Product getProduct() {
        return product;
    }

    public SupplierList getSupplierList() {
        return supplierList;
    }
}
