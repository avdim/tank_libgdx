package com.riseofcat.tank;

import java.util.Random;

public class Lib {

    private static final Random rand = new Random();

    public static int random(int min, int max) {
        return min + rand.nextInt(max - min + 1);
    }

}
