package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("roll")
                .burgers(2)
                .sauce("barbecue")
                .ingredients("onion")
                .ingredients("bacon")
                .ingredients("Mushrooms")
                .build();
        System.out.println(bigmac);
        //When
        int numberOfIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(3, numberOfIngredients);
    }
}
