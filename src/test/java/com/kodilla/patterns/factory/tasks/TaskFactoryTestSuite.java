package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testTaskFactoryCreateDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVINGTASK);
        //When
        drivingTask.executeTask();
        String taskName = drivingTask.getTaskName();
        boolean isExecuted = drivingTask.isTaskExecuted();
        //Then
        Assert.assertEquals("Go to post", taskName);
        Assert.assertTrue(isExecuted);
    }

    @Test
    public void testTaskFactoryCreatePaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTINGTASK);
        //When
        paintingTask.executeTask();
        String taskName = paintingTask.getTaskName();
        boolean isExecuted = paintingTask.isTaskExecuted();
        //Then
        Assert.assertEquals("Order for mrs Johnsson", taskName);
        Assert.assertTrue(isExecuted);
    }

    @Test
    public void testTaskFactoryCreateShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPINGTASK);
        //When
        shoppingTask.executeTask();
        String taskName = shoppingTask.getTaskName();
        boolean isExecuted = shoppingTask.isTaskExecuted();
        //Then
        Assert.assertEquals("Buy cosmetics", taskName);
        Assert.assertTrue(isExecuted);
    }
}
