package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialnetworks.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.users.Millenials;
import com.kodilla.patterns.strategy.social.users.User;
import com.kodilla.patterns.strategy.social.users.YGeneration;
import com.kodilla.patterns.strategy.social.users.ZGeneration;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User millenialUser = new Millenials("MillenialUser");
        User yGenerationUser = new YGeneration("YGenerationUser");
        User zGenerationUser = new ZGeneration("ZGenerationUser");

        //When
        String milenialSocialPublisher = millenialUser.sharePost();
        System.out.println("Millenials share post on: " + milenialSocialPublisher);
        String yGenerationSocialPublisher = yGenerationUser.sharePost();
        System.out.println("Y Generation share post on: " + yGenerationSocialPublisher);
        String zGenerationSocialPublisher = zGenerationUser.sharePost();
        System.out.println("Z Generation share post on: " + zGenerationSocialPublisher);

        //Then
        assertEquals("Facebook", milenialSocialPublisher);
        assertEquals("Twitter", yGenerationSocialPublisher);
        assertEquals("Snapchat", zGenerationSocialPublisher);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user = new Millenials("MillenialUser");

        //When
        String result = user.sharePost();
        System.out.println("User share post on: " + result);
        user.setSocialPublisher(new SnapchatPublisher());
        result = user.sharePost();
        System.out.println("User share post on: " + result);

        //Then
        assertEquals("Snapchat", result);
    }
}
