package TaskOne.Util;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max);
    }

    private Random() {
    }
}
