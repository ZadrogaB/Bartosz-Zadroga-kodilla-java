package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.Product;
import com.kodilla.good.patterns.challenges.exercise4.orders.InformationService;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.orders.OrderService;

import java.util.List;
import java.util.stream.Collectors;

public interface Supplier {
    String getCompanyName();
    List<Product> getProductList();

    default void addProductToList(Product product, List<Product> productList) {
        productList.add(product);
    }

    default void removeProductFromList(Product product, List<Product> productList) {
        productList.stream()
                .filter(n-> n.equals(product))
                .map(n -> n.getNumberOfProducts()-product.getNumberOfProducts());
    }

    default int getNumberOfProduct(Product product, List<Product> productList) {
        List<Integer> result = productList.stream()
                .filter(n-> n.equals(product))
                .map(n -> n.getNumberOfProducts())
                .collect(Collectors.toList());
        return result.get(0);
    }

    default void process(final OrderRequest orderRequest,
                         final InformationService informationService,
                         final OrderService orderService) {
        if(orderRequest.getProduct().getNumberOfProducts() <
        orderRequest.getSupplier().getNumberOfProduct(orderRequest.getProduct(), orderRequest.getSupplier().getProductList())) {
            informationService.inform(orderRequest.getClient());
            orderService.order(orderRequest);
            orderRequest.getSupplier().removeProductFromList(orderRequest.getProduct(), orderRequest.getSupplier().getProductList());
        } else {
            System.out.println("Sprzedawca ma mniej produktu niż zamawiasz! Zamówienie nieudane.");
        }
    }
}
