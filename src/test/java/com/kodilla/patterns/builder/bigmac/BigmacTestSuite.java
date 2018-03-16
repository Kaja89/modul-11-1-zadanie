package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBuildBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .burgers(2)
                .roll("sesame")
                .sauce("barbecue")
                .ingredients("lettuce")
                .ingredients("cucamber")
                .ingredients("cheese")
                .build();

        System.out.println(bigmac);
        //When
        int ingredientsAmount = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(3, ingredientsAmount);
    }

    @Test
    public void testBuildBigmacWithoutSauce() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .ingredients("prawns")
                .ingredients("cheese")
                .roll("classic")
                .burgers(4)
                .build();

        System.out.println(bigmac);
        //When
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        //Then
        Assert.assertEquals(4, burgers);
        Assert.assertNull(sauce);
    }

    @Test
    public void testBuildBicmacWithoutBurger() {
        //Given
        boolean thrown = false;
        //When
        try {
            Bigmac bigmac = new Bigmac.BigMacBuilder()
                    .sauce("standard")
                    .ingredients("onion")
                    .ingredients("beacon")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println(e);
            thrown = true;
        }
        //Then
        Assert.assertTrue(thrown);
    }
}
