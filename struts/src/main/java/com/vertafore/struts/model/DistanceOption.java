package com.vertafore.struts.model;

import java.util.Random;

public enum DistanceOption {
    WASHING_MACHINE, BEARD, LIGHT;

    private static final Random RANDOM = new Random();
    private static final DistanceOption[] VALUES = values();

    public static DistanceOption getRandomOption() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }

    public static Double getOptionFactor(DistanceOption option) {
        switch (option) {
            case WASHING_MACHINE:
                return 1.45815;
            case BEARD:
                return 78.74016;
            case LIGHT:
                return 3.33564095;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public static String getResponseText(DistanceOption option) {
        switch (option) {
            case WASHING_MACHINE:
                return "%s washing machines would cover your distance of %s meters";
            case BEARD:
                return "The average male beard would take %s years to grow your distance of %s meters";
            case LIGHT:
                return "Light would take %s nanoseconds to cover your distance of %s meters";
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
