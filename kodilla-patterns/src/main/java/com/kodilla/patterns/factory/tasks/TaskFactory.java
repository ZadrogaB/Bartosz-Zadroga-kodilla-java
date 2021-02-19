package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String task) {
        switch (task) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping", "Bananas", 20);
            case PAINTING_TASK:
                return new PaintingTask("Painting", "Red", "Another brick in the wall");
            case DRIVING_TASK:
                return new DrivingTask("Driving", "Home", "Bus");
            default:
                return null;
        }
    }

}
