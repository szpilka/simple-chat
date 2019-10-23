package kasia.simple.chat.util;

import java.util.Random;

public class ParrotInputProvider implements InputProvider {
    private final Random random = new Random();

    @Override
    public String readLine() {
        try {
            Thread.sleep(1000 * (random.nextInt(10) + 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "I'm a parrot";
    }
}
