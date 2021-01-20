package org.jakartaeerecipes.chapter02.recipe02_03;

import java.util.Random;

/**
 * Recipe 2-3
 *
 * @author juneau
 */
public class RandomBean implements java.io.Serializable {
    private Random randomGenerator = new Random();

    /**
     * @return the randomNumber
     */
    public int getRandomNumber() {
        return randomGenerator.nextInt();
    }

}
