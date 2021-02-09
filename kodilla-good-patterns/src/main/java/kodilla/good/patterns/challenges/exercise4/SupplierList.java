package kodilla.good.patterns.challenges.exercise4;

import kodilla.good.patterns.challenges.exercise4.objects.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SupplierList {
    List<Supplier> supplierList = new ArrayList<>();

    public void addSupplierToList (Supplier supplier){
        supplierList.add(supplier);
    }

    public Supplier getSupplierFromList(String companyName){
        List<Supplier> resultList= supplierList.stream()
                .filter(n -> n.getCompanyName().equals(companyName))
                .collect(Collectors.toList());

        return resultList.get(0);
    }
}
