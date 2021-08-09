package ru.rav.first;

public class PongThread extends CommonPingPongThread implements Runnable {

    public PongThread(PingPongManager pingPongManager) {
        super(pingPongManager);
    }

    @Override
    public void run() {
        while (true) {
            pingPongManager.showPong();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
