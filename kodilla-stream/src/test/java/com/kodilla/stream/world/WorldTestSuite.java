package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent europe = new Continent("Europe");
        Country poland = new Country("Poland", new BigDecimal("38259725"));
        Country germany = new Country("Germany", new BigDecimal("83025851"));
        Country england = new Country("England", new BigDecimal("55958145"));
        europe.addToCountryList(poland);
        europe.addToCountryList(germany);
        europe.addToCountryList(england);

        Continent asia = new Continent("Asia");
        Country japan = new Country("Japan", new BigDecimal("126502187"));
        Country china = new Country("China", new BigDecimal("1393528731"));
        Country taiwan = new Country("Taiwan", new BigDecimal("23570851"));
        asia.addToCountryList(japan);
        asia.addToCountryList(china);
        asia.addToCountryList(taiwan);

        Continent africa = new Continent("Africa");
        Country sudan = new Country("Sudan", new BigDecimal("41806732"));
        Country nigeria = new Country("Nigeria", new BigDecimal("195987654"));
        Country mali = new Country("Mali", new BigDecimal("19081834"));
        africa.addToCountryList(sudan);
        africa.addToCountryList(nigeria);
        africa.addToCountryList(mali);

        World world = new World();
        world.addToContinentList(europe);
        world.addToContinentList(asia);
        world.addToContinentList(africa);


        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();


        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("1977721710");
        assertEquals(expectedPeopleQuantity, totalPeopleQuantity);
    }
}
