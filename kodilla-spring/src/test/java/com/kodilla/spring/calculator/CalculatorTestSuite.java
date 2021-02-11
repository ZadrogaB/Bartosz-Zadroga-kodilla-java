package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private  Calculator calculator;

    @Test
    void testCalculations(){
        //Given
        //When
        double resultAdd = calculator.add(6,6);
        double resultSub = calculator.sub(8,2);
        double resultMul = calculator.mul(5,7);
        double resultDiv = calculator.div(20,4);
        //Then
        assertEquals(12, resultAdd);
        assertEquals(6, resultSub);
        assertEquals(35, resultMul);
        assertEquals(5, resultDiv);
    }
}
