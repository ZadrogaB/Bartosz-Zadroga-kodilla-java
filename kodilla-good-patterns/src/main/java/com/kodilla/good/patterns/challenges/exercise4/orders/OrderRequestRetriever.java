package com.kodilla.good.patterns.challenges.exercise4.orders;


import com.kodilla.good.patterns.challenges.exercise4.objects.SupplierList;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;
import com.kodilla.good.patterns.challenges.exercise4.shops.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.exercise4.shops.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.exercise4.shops.HealthyShop;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {
    public List<OrderRequest> retrieve() {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();
        SupplierList supplierList = new SupplierList();
        supplierList.addSupplierToList(extraFoodShop);
        supplierList.addSupplierToList(glutenFreeShop);
        supplierList.addSupplierToList(healthyShop);
        Product product = new Product("Product2",1,1);
        List<OrderRequest> orderRequests = new ArrayList<>();
        orderRequests.add(new OrderRequest(product, extraFoodShop));
        orderRequests.add(new OrderRequest(product, glutenFreeShop));
        orderRequests.add(new OrderRequest(product, healthyShop));

        return orderRequests;
    }

}
