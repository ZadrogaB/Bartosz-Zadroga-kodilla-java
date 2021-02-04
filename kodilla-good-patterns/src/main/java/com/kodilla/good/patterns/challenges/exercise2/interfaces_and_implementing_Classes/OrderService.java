package com.kodilla.good.patterns.challenges.exercise2.interfaces_and_implementing_Classes;

import com.kodilla.good.patterns.challenges.exercise2.objects.Product;
import com.kodilla.good.patterns.challenges.exercise2.objects.User;

import java.time.LocalDateTime;


public interface OrderService {
    boolean order(final User user, final Product product, final LocalDateTime dateOfOrder);
}
