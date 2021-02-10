package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GlutenFreeShop implements Supplier {
    private String companyName = "GlutenFreeShop";
    private List<Product> productList = new ArrayList<>();

    public GlutenFreeShop(){
        productList.add(new Product("Product1",5,5));
        productList.add(new Product("Product2",5,5));
        productList.add(new Product("Product3",5,5));
    }

    public OrderRequestDto process(OrderRequest orderRequest){
        List<Product> resultList = productList.stream()
                .filter(n->n.getProductName().equals(orderRequest.getProduct().getProductName()))
                .collect(Collectors.toList());

        if(resultList.size()>0) {
            return new OrderRequestDto(orderRequest, true, "Produkt na magazynie. Wysyłka zostanie zrealizowana niebawem.");
        } else {
            return new OrderRequestDto(orderRequest, false, "Produktu nie ma na magazynie. Wysyłka nie zostanie zrealizowana.");
        }
    }
}
