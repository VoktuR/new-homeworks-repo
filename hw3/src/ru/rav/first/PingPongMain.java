package ru.rav.first;

public class PingPongMain {

    public static void main(String[] args) {

        PingPongManager pingPongManager = new PingPongManager();
        Thread ping = new Thread(new PingThread(pingPongManager));
        Thread pong = new Thread(new PongThread(pingPongManager));
        ping.start();
        pong.start();

    }

}
