package interthreadcommunication.locks;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    private static void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}
