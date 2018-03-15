package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    final static String DRIVINGTASK = "DRIVINGTASK";
    final static String SHOPPINGTASK = "SHOPPINGTASK";
    final static String PAINTINGTASK = "PAINTINGTASK";

    public final Task createTask(String taskClass) {
        switch (taskClass) {
            case DRIVINGTASK:
                return new DrivingTask("Go to post", "Post office", "car");
            case SHOPPINGTASK:
                return new ShoppingTask("Buy cosmetics", "Shampoo", 2.0);
            case PAINTINGTASK:
                return new PaintingTask("Order for mrs Johnsson", "blue", "Mrs Johnsson's portrait");
            default:
                return null;
        }
    }
}
