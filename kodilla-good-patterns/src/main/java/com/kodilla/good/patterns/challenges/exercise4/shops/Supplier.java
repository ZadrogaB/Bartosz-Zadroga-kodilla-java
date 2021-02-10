package com.kodilla.good.patterns.challenges.exercise4.shops;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;

public interface Supplier {
    OrderRequestDto process(OrderRequest orderRequest);
}
