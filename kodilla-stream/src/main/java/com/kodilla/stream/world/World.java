package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class World {
    private final List<Continent> continentList = new ArrayList<>();


    public void addToContinentList(Continent continent){
        continentList.add(continent);
    }


    public List<Continent> getContinentList() {
        return continentList;
    }

    public BigDecimal getPeopleQuantity(){
        BigDecimal totalPeopleQuantity =  continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum=sum.add(current));

        return totalPeopleQuantity;
    }
}
