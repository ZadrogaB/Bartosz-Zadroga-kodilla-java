package com.kodilla.good.patterns.challenges.exercise2.model;

public class Product {
    private String nameOfProduct;
    private User dealerName;

    public Product(String nameOfProduct, User dealerName) {
        this.nameOfProduct = nameOfProduct;
        this.dealerName = dealerName;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public User getDealerName() {
        return dealerName;
    }
}
