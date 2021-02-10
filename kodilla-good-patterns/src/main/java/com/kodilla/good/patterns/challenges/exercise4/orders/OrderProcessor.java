package com.kodilla.good.patterns.challenges.exercise4.orders;

import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import com.kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import com.kodilla.good.patterns.challenges.exercise4.shops.Supplier;


public class OrderProcessor {

    public void process(String companyName , OrderRequest orderRequest){
        Supplier supplier = orderRequest.getSupplierList().getSupplierFromList(companyName);
        OrderRequestDto orderRequestDto = supplier.process(orderRequest);
        OrderInformation information = new OrderInformation();
        information.inform(orderRequestDto, companyName);
    }
}
