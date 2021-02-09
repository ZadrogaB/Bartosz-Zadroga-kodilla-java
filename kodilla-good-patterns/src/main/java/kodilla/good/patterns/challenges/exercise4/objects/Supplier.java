package kodilla.good.patterns.challenges.exercise4.objects;

import kodilla.good.patterns.challenges.exercise4.SupplierInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Supplier implements SupplierInterface {
    private String companyName;
    private List<Product> productList = new ArrayList<>();

    public Supplier(String companyName) {
        this.companyName = companyName;
    }

    public void addProductToList(Product product) {
        productList.add(product);
    }

    public void removeProductFromList(Product product) {
        productList.stream()
                .filter(n-> n.equals(product))
                .map(n -> n.getNumberOfProducts()-product.getNumberOfProducts());
    }

    public int getNumberOfProduct(Product product) {
        List<Integer> result = productList.stream()
                .filter(n-> n.equals(product))
                .map(n -> n.getNumberOfProducts())
                .collect(Collectors.toList());
        return result.get(0);
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

}
