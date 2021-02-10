package com.kodilla.good.patterns.challenges.exercise4.orders;


import com.kodilla.good.patterns.challenges.exercise4.objects.SupplierList;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;
import com.kodilla.good.patterns.challenges.exercise4.shops.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.exercise4.shops.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.exercise4.shops.HealthyShop;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();
        SupplierList supplierList = new SupplierList();
        supplierList.addSupplierToList(extraFoodShop);
        supplierList.addSupplierToList(glutenFreeShop);
        supplierList.addSupplierToList(healthyShop);
        Product product = new Product("Produkt2",1,1);

        return new OrderRequest(product, supplierList);
    }

}
