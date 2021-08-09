package ru.rav.second;

import java.util.concurrent.locks.Lock;

public class CounterThread implements Runnable {

    private Lock locker;

    public CounterThread(Lock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            for (int i = 0; i < 10; i++) {
                CommonCounter.increase();
            }
        } finally {
            locker.unlock();
        }
    }
}
