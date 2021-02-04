package com.kodilla.good.patterns.challenges.exercise2.service;

import com.kodilla.good.patterns.challenges.exercise2.model.Product;
import com.kodilla.good.patterns.challenges.exercise2.model.User;
import com.kodilla.good.patterns.challenges.exercise2.service.OrderService;

import java.time.LocalDateTime;

public class OrderProduct implements OrderService {

     public boolean order(final User user, final Product product, final LocalDateTime dateOfOrder){
         System.out.println("Product buy: " + user.getName()+ " " + user.getSurname()
                 + ".\nDate of transaction: " + dateOfOrder
                 + ".\nProduct dealer was: " + product.getDealerName().getName()+ " "
                 + product.getDealerName().getSurname() + ".\nProduct name was: " + product.getNameOfProduct() +"\n");

         return true;
    }
}
