package com.kodilla.good.patterns.challenges.exercise2.orders;

import com.kodilla.good.patterns.challenges.exercise2.interfaces_and_implementing_Classes.InformationService;
import com.kodilla.good.patterns.challenges.exercise2.interfaces_and_implementing_Classes.OrderService;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService) {
        this.informationService = informationService;
        this.orderService = orderService;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getDateOfOrder());
        if(isOrdered){
            informationService.inform(orderRequest.getUser());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }


}
