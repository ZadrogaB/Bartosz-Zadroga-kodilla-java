package kodilla.good.patterns.challenges.exercise4.orders;

import kodilla.good.patterns.challenges.exercise4.SupplierList;
import kodilla.good.patterns.challenges.exercise4.objects.*;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        Product product = new Product("Marchew Bio", 7, 5);
        Supplier extraFoodShop = new Supplier("ExtraFoodShop");
        Product supplierProduct = new Product("Marchew Bio", 50, 5);
        extraFoodShop.addProductToList(supplierProduct);
        SupplierList supplierList = new SupplierList();
        supplierList.addSupplierToList(extraFoodShop);
        Client client = new Client("Krzysztof", "Krawczyk");
        return new OrderRequest(product, client, supplierList);
    }

}
