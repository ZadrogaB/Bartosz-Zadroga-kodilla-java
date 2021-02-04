package com.kodilla.good.patterns.challenges.exercise2.service;

import com.kodilla.good.patterns.challenges.exercise2.dto.OrderDto;
import com.kodilla.good.patterns.challenges.exercise2.service.InformationService;
import com.kodilla.good.patterns.challenges.exercise2.service.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise2.service.OrderService;

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
