package com.kodilla.good.patterns.challenges.exercise2.service;

import com.kodilla.good.patterns.challenges.exercise2.model.Product;
import com.kodilla.good.patterns.challenges.exercise2.model.User;

import java.time.LocalDateTime;

public class OrderServiceRetriever {

    public OrderRequest retrieve(){
        User user = new User("Jan", "Nowak");
        User dealerName = new User("Krzysztof", "Krawczyk");
        LocalDateTime dateOfOrder = LocalDateTime.of(2021,1,25,15,14);
        Product product = new Product("Parostatek", dealerName);

        return new OrderRequest(user, dateOfOrder, product);

    }
}
