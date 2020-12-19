package com.kodilla.stream.invoice.simple;

public final class SimpleProduct {
    private final String productName;
    private final double productPrice;

    public SimpleProduct(final String productName,final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleProduct that = (SimpleProduct) o;

        if (Double.compare(that.productPrice, productPrice) != 0) return false;
        return productName != null ? productName.equals(that.productName) : that.productName == null;
    }

}
