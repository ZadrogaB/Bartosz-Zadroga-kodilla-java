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
        Mentor mentorOne = new Mentor("mentor1");
        Mentor mentorTwo = new Mentor("mentor2");
        TaskList taskListOne = new TaskList("taskListOne");
        TaskList taskListTwo = new TaskList("taskListTwo");
        TaskList taskListOneAndTwo = new TaskList("taskListThree");
        taskListOne.registerObserver(mentorOne);
        taskListTwo.registerObserver(mentorTwo);
        taskListOneAndTwo.registerObserver(mentorOne);
        taskListOneAndTwo.registerObserver(mentorTwo);
        //When
        taskListOne.addTask("aaa");
        taskListTwo.addTask("aaa");
        taskListTwo.addTask("aaa");
        taskListOneAndTwo.addTask("aaa");
        taskListOneAndTwo.addTask("aaa");
        taskListOneAndTwo.addTask("aaa");
        //Then
        assertEquals(4, mentorOne.getUpdateCount());
        assertEquals(5, mentorTwo.getUpdateCount());
    }

}