package com.kodilla.patterns.factory.tasks;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);
        boolean unExecuted = drivingTask.isTaskExecuted();
        drivingTask.executeTask();
        boolean executed = drivingTask.isTaskExecuted();
        //Then
        assertEquals("Driving", drivingTask.getTaskName());
        assertEquals(false, unExecuted);
        assertEquals(true, executed);
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);
        boolean unExecuted = paintingTask.isTaskExecuted();
        paintingTask.executeTask();
        boolean executed = paintingTask.isTaskExecuted();
        //Then
        assertEquals("Painting", paintingTask.getTaskName());
        assertEquals(false, unExecuted);
        assertEquals(true, executed);
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);
        boolean unExecuted = shoppingTask.isTaskExecuted();
        shoppingTask.executeTask();
        boolean executed = shoppingTask.isTaskExecuted();
        //Then
        assertEquals("Shopping", shoppingTask.getTaskName());
        assertEquals(false, unExecuted);
        assertEquals(true, executed);
    }
}
