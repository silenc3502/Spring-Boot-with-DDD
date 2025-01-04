package com.example.demo.utility;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public static int generate(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min이 max 보다 클 수 없다.");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
