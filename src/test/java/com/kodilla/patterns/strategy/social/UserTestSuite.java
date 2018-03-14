package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.media.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.users.Millenials;
import com.kodilla.patterns.strategy.social.users.User;
import com.kodilla.patterns.strategy.social.users.YGeneration;
import com.kodilla.patterns.strategy.social.users.ZGeneration;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User bob = new Millenials("Bob");
        User rob = new YGeneration("Rob");
        User jim = new ZGeneration("Jim");

        //When
        String bobStrategy = bob.sharePost();
        System.out.println(bobStrategy);
        String robStrategy = rob.sharePost();
        System.out.println(robStrategy);
        String jimStrategy = jim.sharePost();
        System.out.println(jimStrategy);

        //Then
        Assert.assertEquals("Facebook", bobStrategy);
        Assert.assertEquals("Snapchat", robStrategy);
        Assert.assertEquals("Twitter", jimStrategy);
    }

    @Test
    public void testIndividualStrategy() {
        //Given
        User bob = new Millenials("bob");
        //When
        String bobStrategy = bob.sharePost();
        System.out.println(bob.getUsername() + " prefers " + bobStrategy);
        bob.setSocialPublisher(new SnapchatPublisher());
        bobStrategy = bob.sharePost();
        System.out.println("But he decided to use: " + bobStrategy);
        //Then
        Assert.assertEquals("Snapchat", bobStrategy);
    }
}
