package ru.rav.second;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterMain {

    public static void main(String[] args) {

        Lock locker = new ReentrantLock();

        Thread firstCounterThread = new Thread(new CounterThread(locker));
        Thread secondCounterThread = new Thread(new CounterThread(locker));
        firstCounterThread.start();
        secondCounterThread.start();
        try {
            firstCounterThread.join();
            secondCounterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(CommonCounter.getCounter());


    }

}
