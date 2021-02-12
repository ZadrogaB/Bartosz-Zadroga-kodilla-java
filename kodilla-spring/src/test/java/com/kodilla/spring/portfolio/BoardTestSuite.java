package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        //When
        board.getDoneList().addTask("Task1");
        board.getInProgressList().addTask("Task2");
        board.getToDoList().addTask("Task3");
        String resultDoneList = board.getDoneList().getTask(0);
        String resultInProgressList = board.getInProgressList().getTask(0);
        String resultToDoList = board.getToDoList().getTask(0);

        //Then
        assertEquals("Task1", resultDoneList);
        assertEquals("Task2", resultInProgressList);
        assertEquals("Task3", resultToDoList);
    }
}
