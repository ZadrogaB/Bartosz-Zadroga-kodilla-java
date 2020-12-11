package com.kodilla.testing.collection;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }

    @DisplayName("when send empty list, " +
            "then OddNumbersExterminator should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> testList = new ArrayList<>();
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(testList);
        //Then
        Assertions.assertEquals(testList, result);
    }

    @DisplayName("when send list, " +
            "then OddNumbersExterminator should return list without odd numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> testList = new ArrayList<>(Arrays.asList(2,25,8));
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(testList);
        List<Integer> testResultExpected= new LinkedList<>();
        testResultExpected.add(2);
        testResultExpected.add(8);
        //Then
        Assertions.assertEquals(testResultExpected, result);

    }
}
