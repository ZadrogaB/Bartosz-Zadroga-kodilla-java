package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.Product;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements Supplier {
    private String companyName = "HealthyShop";
    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }
}
