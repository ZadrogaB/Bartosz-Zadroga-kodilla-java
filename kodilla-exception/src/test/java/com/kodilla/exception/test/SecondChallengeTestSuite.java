package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SecondChallengeTestSuite {

    @Test
    void boundaryYValue(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(1.5,1.5));
    }

    @Test
    void boundaryXValueOverOrEqualsTwo(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(2,1));
    }

    @Test
    void boundaryXValueUnderOne(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(0.99,1.5));
    }

    @Test
    void goodValues(){
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertDoesNotThrow(()->secondChallenge.probablyIWillThrowException(1.5,2));
    }
}
