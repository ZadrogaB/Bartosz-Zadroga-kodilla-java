package com.kodilla.stream.world;

import com.kodilla.stream.sand.Africa;
import com.kodilla.stream.sand.Asia;
import com.kodilla.stream.sand.Europe;
import com.kodilla.stream.sand.SandStorage;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent Europe = new Continent("Europe");
        Country Poland = new Country("Poland", new BigDecimal("38259725"));
        Country Germany = new Country("Germany", new BigDecimal("83025851"));
        Country England = new Country("England", new BigDecimal("55958145"));
        Europe.addToCountryList(Poland);
        Europe.addToCountryList(Germany);
        Europe.addToCountryList(England);

        Continent Asia = new Continent("Asia");
        Country Japan = new Country("Japan", new BigDecimal("126502187"));
        Country China = new Country("China", new BigDecimal("1393528731"));
        Country Taiwan = new Country("Taiwan", new BigDecimal("23570851"));
        Asia.addToCountryList(Japan);
        Asia.addToCountryList(China);
        Asia.addToCountryList(Taiwan);

        Continent Africa = new Continent("Africa");
        Country Sudan = new Country("Sudan", new BigDecimal("41806732"));
        Country Nigeria = new Country("Nigeria", new BigDecimal("195987654"));
        Country Mali = new Country("Mali", new BigDecimal("19081834"));
        Africa.addToCountryList(Sudan);
        Africa.addToCountryList(Nigeria);
        Africa.addToCountryList(Mali);

        World world = new World();
        world.addToContinentList(Europe);
        world.addToContinentList(Asia);
        world.addToContinentList(Africa);


        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();


        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("1977721710");
        assertEquals(expectedPeopleQuantity, totalPeopleQuantity);
    }
}
