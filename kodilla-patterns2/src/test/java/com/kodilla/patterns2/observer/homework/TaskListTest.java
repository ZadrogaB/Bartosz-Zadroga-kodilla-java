package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @BeforeEach
    void setUp() {
        System.out.println("-----STARTING TEST-----");

    }

    @AfterEach
    void tearDown() {
        System.out.println("-----ENDING TEST-----");

    }

    @Test
    void NumberOfMentorTestsTestSuite() {
        //Given
        Mentor mentor = new Mentor("mentor");
        TaskList mentorTaskList = new TaskList(mentor);
        //When
        mentorTaskList.addTask("Task one");
        mentorTaskList.addTask("Task two");
        mentorTaskList.addTask("Task three");
        //Then
        assertEquals(3, mentor.getUpdateCount());

    }

}