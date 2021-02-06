package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.Product;
import com.kodilla.good.patterns.challenges.exercise4.orders.InformationService;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.orders.OrderService;

public interface Supplier {
    String getCompanyName();
    void addProductToList(Product product);
    void removeProductFromList(Product product);
     int getNumberOfProduct(Product product);


    default void process(final OrderRequest orderRequest,
                         final InformationService informationService,
                         final OrderService orderService) {
        if(orderRequest.getProduct().getNumberOfProducts() <
        orderRequest.getSupplier().getNumberOfProduct(orderRequest.getProduct())) {
            informationService.inform(orderRequest.getClient());
            orderService.order(orderRequest);
            orderRequest.getSupplier().removeProductFromList(orderRequest.getProduct());
        } else {
            System.out.println("Sprzedawca ma mniej produktu niż zamawiasz! Zamówienie nieudane.");
        }
    }

}
