package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.customers.CorporateCustomer;
import com.kodilla.patterns.strategy.customers.Customer;
import com.kodilla.patterns.strategy.customers.IndividualCustomer;
import com.kodilla.patterns.strategy.customers.IndividualYoungCustomer;
import com.kodilla.patterns.strategy.predictors.AgressivePredictor;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTestSuite {
    @Test
    public void testDefaultInvestingStrategies(){
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla: " + kodillaShouldBuy);

        //Then
        Assert.assertEquals("[Conservative predictor] Buy debentures od XYZ" , stevenShouldBuy);
        Assert.assertEquals("[Agressive predictor] Buy stock of XYZ", johnShouldBuy);
        Assert.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    public void testIndividualInvestingStrategy(){
        //Given
        Customer steven = new IndividualCustomer("Steven Links");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AgressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);

        //Then
        Assert.assertEquals("[Agressive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
