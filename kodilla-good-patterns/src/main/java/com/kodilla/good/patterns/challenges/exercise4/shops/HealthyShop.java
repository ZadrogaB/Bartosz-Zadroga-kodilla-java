package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements Supplier {
    private String companyName = "ExtraFoodShop";
    private List<Product> productList = new ArrayList<>();

    public HealthyShop(){
        productList.add(new Product("Product4",5,5));
        productList.add(new Product("Product5",5,5));
        productList.add(new Product("Product6",5,5));
    }

    public OrderRequestDto process(OrderRequest orderRequest){
        return new OrderRequestDto(orderRequest, false, "Z powodu problemów technicznych nie zrealizujemy zmaówienie. Przepraszamy.");
    }
}
