package com.kodilla.good.patterns.challenges.exercise4.orders;


import com.kodilla.good.patterns.challenges.exercise4.objects.SupplierList;
import com.kodilla.good.patterns.challenges.exercise4.objects.Client;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;
import com.kodilla.good.patterns.challenges.exercise4.objects.Supplier;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        Product product = new Product("Marchew Bio", 10, 5);
        Supplier extraFoodShop = new Supplier("ExtraFoodShop");
        Product supplierProduct = new Product("Marchew Bio", 50, 5);
        extraFoodShop.addProductToList(supplierProduct);
        SupplierList supplierList = new SupplierList();
        supplierList.addSupplierToList(extraFoodShop);
        Client client = new Client("Krzysztof", "Krawczyk");
        return new OrderRequest(product, client, supplierList);
    }

}
