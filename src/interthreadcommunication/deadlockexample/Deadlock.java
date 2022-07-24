package interthreadcommunication.deadlockexample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    // cyclic locking example for deadlock
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        new Thread(deadlock::worker1, "t1").start();
        new Thread(deadlock::worker2, "t2").start();
    }

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires the lock1...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker1 acquires the lock2...");

        lock1.unlock();
        lock2.unlock();
    }

    // using same order is the solution
    public void worker2() {
        lock2.lock(); // lock1.lock()
        System.out.println("Worker2 acquires the lock2...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock(); // lock2.lock()
        System.out.println("Worker2 acquires the lock1...");

        lock1.unlock();
        lock2.unlock();
    }

}
