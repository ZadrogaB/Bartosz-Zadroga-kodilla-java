package kodilla.good.patterns.challenges.exercise4.objects;

import kodilla.good.patterns.challenges.exercise4.SupplierList;

public class OrderRequest {
    private Product product;
    private Client client;
    private SupplierList supplierList;

    public OrderRequest(Product product, Client client, SupplierList supplierList) {
        this.product = product;
        this.client = client;
        this.supplierList = supplierList;
    }

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    public SupplierList getSupplierList() {
        return supplierList;
    }
}
