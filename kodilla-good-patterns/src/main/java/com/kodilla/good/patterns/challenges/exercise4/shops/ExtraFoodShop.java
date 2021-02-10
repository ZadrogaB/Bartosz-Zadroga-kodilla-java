package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements Supplier {
    private String companyName = "ExtraFoodShop";
    private List<Product> productList = new ArrayList<>();

    public ExtraFoodShop(){
        productList.add(new Product("Product7",5,5));
        productList.add(new Product("Product8",5,5));
        productList.add(new Product("Product9",5,5));
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    public OrderRequestDto process(OrderRequest orderRequest){
        return new OrderRequestDto(orderRequest, true, "Produkt zostanie wysłany po zebraniu plonów.");    }
}
