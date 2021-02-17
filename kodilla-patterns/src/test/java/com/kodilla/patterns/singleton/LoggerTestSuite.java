package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    @Test
    void getLastLogTest(){
        //Given
        Logger logger = Logger.LOGGER;
        //When
        logger.log("LastLog");
        String result = logger.getLastLog();
        //Then
        assertEquals("LastLog",result);
    }
}
