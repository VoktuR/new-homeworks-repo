package ru.rav.first;

public class PingPongManager {

    private String word = "Ping";

    public synchronized void showPing() {
        while (!word.equals("Ping")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(word);
        word = "Pong";
        notifyAll();
    }

    public synchronized void showPong() {
        while (!word.equals("Pong")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(word);
        word = "Ping";
        notifyAll();
    }

}
