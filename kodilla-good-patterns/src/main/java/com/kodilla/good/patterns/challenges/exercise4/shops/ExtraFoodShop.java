package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.Product;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements Supplier {

    private String companyName = "ExtraFoodShop";
    private List<Product> productList = new ArrayList<>();

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }
}
