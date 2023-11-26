package org.example.entityTask;

import java.util.Random;

public enum Priority {
    CRITICAL, HIGH, NORMAL, LOW;
    private static final Random RANDOM = new Random();
    private static final Priority[] PRIORITIES = values();

    public static Priority randomPriority(){
        return PRIORITIES[RANDOM.nextInt(PRIORITIES.length)];
    }
}
