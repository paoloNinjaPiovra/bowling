package com.bowling.bowling.util;

import java.util.Random;

public class Shoot {

    public static int shoot(int min, int max) {
        if (min < max) {
            return new Random().nextInt((max - min) + 1) + min;
        }
        return 0;
    }

    public static int shootBonus() {
        return shoot(0, 10);
    }
}
