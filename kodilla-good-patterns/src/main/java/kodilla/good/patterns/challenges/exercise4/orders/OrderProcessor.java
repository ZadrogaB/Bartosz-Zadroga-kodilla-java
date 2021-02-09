package kodilla.good.patterns.challenges.exercise4.orders;

import kodilla.good.patterns.challenges.exercise4.objects.OrderRequestDto;
import kodilla.good.patterns.challenges.exercise4.objects.OrderRequest;
import kodilla.good.patterns.challenges.exercise4.objects.Supplier;

public class OrderProcessor {

    public OrderRequestDto process(Supplier supplier , OrderRequest orderRequest){

        if(orderRequest.getProduct().getNumberOfProducts() < supplier.getNumberOfProduct(orderRequest.getProduct())) {
            supplier.removeProductFromList(orderRequest.getProduct());
            return new OrderRequestDto(orderRequest, true, supplier);
        } else {
            return new OrderRequestDto(orderRequest, false, supplier);
        }
    }
}
