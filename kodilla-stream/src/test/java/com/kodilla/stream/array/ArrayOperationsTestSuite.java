package com.kodilla.stream.array;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        Random random = new Random();
        int[] testArray = new int[10];
        int sum =0;
        for (int i=0; i<10; i++){
            testArray[i] = random.nextInt(100);
            sum+= testArray[i];
        }
        double expected = Double.valueOf(sum)/10.0;
        System.out.println("Expected: " + expected);
        //When
        double result = ArrayOperations.getAverage(testArray);
        System.out.println("Result" + result);

        //Then
        assertEquals(expected, result, 0.01);
    }
}
