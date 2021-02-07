package com.kodilla.good.patterns.challenges.exercise4.orders;


import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;

public interface OrderService {
    boolean order(final OrderRequest orderRequest);
}
