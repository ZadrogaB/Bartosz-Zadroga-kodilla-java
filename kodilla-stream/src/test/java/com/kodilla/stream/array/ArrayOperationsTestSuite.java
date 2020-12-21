package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] testArray = new int[10];
        for (int i=0; i<10; i++){
            testArray[i] = i;
        }

        //When
        double result = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(4.5, result, 0.01);
    }
}
