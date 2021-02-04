package com.kodilla.good.patterns.challenges.exercise2.orders;

import com.kodilla.good.patterns.challenges.exercise2.objects.Product;
import com.kodilla.good.patterns.challenges.exercise2.objects.User;

import java.time.LocalDateTime;

public class OrderRequest {

    private User user;
    private LocalDateTime dateOfOrder;
    private Product product;

    public OrderRequest(final User user,final LocalDateTime dateOfOrder,final Product product) {
        this.user = user;
        this.dateOfOrder = dateOfOrder;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }
    public Product getProduct() {
        return product;
    }
}
