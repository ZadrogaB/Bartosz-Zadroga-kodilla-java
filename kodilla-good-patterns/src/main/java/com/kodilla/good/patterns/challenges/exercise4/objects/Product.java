package com.kodilla.good.patterns.challenges.exercise4.objects;

public class Product {
    private String productName;
    private int numberOfProducts;
    private double price;

    public String getProductName() {
        return productName;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public double getPrice() {
        return price;
    }

    public Product(String productName, int numberOfProducts, double price) {
        this.productName = productName;
        this.numberOfProducts = numberOfProducts;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productName != null ? productName.equals(product.productName) : product.productName == null;
    }

    @Override
    public int hashCode() {
        return productName != null ? productName.hashCode() : 0;
    }
}
