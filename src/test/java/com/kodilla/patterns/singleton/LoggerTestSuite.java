package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("orange");
        Logger.getInstance().log("apple");
        Logger.getInstance().log("pomegranate");

        //When
        String result = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("pomegranate", result);
    }
}
