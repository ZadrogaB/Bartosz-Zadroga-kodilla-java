package com.kodilla.good.patterns.challenges.exercise4.orders;

import com.kodilla.good.patterns.challenges.exercise4.objects.Client;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.Product;
import com.kodilla.good.patterns.challenges.exercise4.shops.Supplier;


public class OrderRequestRetriever {

    public OrderRequest retrieve(Supplier supplier) {
        Product product = new Product("Marchew Bio", 5, 5);
        Product supplierProduct = new Product("Marchew Bio", 50, 5);
        supplier.addProductToList(supplierProduct, supplier.getProductList());
        Client client = new Client("Krzysztof", "Krawczyk", "Parostatkiem@W.PięknyRejs");
        return new OrderRequest(supplier, product, client);
    }
}
