package com.kodilla.good.patterns.challenges.exercise2.service;

import com.kodilla.good.patterns.challenges.exercise2.model.Product;
import com.kodilla.good.patterns.challenges.exercise2.model.User;

import java.time.LocalDateTime;


public interface OrderService {
    boolean order(final User user, final Product product, final LocalDateTime dateOfOrder);
}
