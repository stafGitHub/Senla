package TaskThree.Util;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static double random(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min,max);
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max);
    }

    private Random() {
    }
}
