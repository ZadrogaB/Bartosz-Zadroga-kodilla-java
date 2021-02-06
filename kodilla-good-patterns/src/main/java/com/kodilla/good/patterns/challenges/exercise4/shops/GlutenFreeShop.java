package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GlutenFreeShop implements Supplier {
    private String companyName = "GlutenFreeShop";
    private List<Product> productList = new ArrayList<>();

    public void addProductToList(Product product){
        productList.add(product);
    }

    public void removeProductFromList(Product product) {
        productList.stream()
                .filter(n -> n.equals(product))
                .map(n -> n.getNumberOfProducts()-product.getNumberOfProducts());
    }

    public int getNumberOfProduct(Product product) {
        List<Integer> result = productList.stream()
                .filter(n -> n.equals(product))
                .map(n -> n.getNumberOfProducts())
                .collect(Collectors.toList());
        return result.get(0);
    }

    public String getCompanyName() {
        return companyName;
    }
}
