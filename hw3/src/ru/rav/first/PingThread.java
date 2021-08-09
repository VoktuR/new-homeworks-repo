package ru.rav.first;

public class PingThread extends CommonPingPongThread implements Runnable {

    public PingThread(PingPongManager pingPongManager) {
        super(pingPongManager);
    }

    @Override
    public void run() {
        while (true) {
            pingPongManager.showPing();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
