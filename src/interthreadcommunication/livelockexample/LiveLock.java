package interthreadcommunication.livelockexample;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();

        new Thread(liveLock::worker1, "t1").start();
        new Thread(liveLock::worker2, "t2").start();
    }

    public void worker1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Worker1 acquires the lock1...");
            System.out.println("Worker1 tries to get lock2...");

            if (lock2.tryLock()) {
                System.out.println("Worker1 acquires the lock2...");
                lock2.unlock();
            } else {
                System.out.println("Worker1 can not acquire lock2...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Worker2 acquires the lock2...");
            System.out.println("Worker2 tries to get lock1...");

            if (lock1.tryLock()) {
                System.out.println("Worker2 acquires the lock1..");
                lock1.unlock();
            } else {
                System.out.println("Worker2 can not acquire lock1...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

}
