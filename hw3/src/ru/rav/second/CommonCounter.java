package ru.rav.second;

public class CommonCounter {

    private static int counter = 0;

    public static void increase() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

}
