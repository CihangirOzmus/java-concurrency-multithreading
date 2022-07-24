package interthreadcommunication.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        condition.await(); //wait()
        System.out.println("Again the producer method...");
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        lock.lock();
        System.out.println("Consumer method...");
        Thread.sleep(3000);
        condition.signal(); //notify()
        lock.unlock();
    }
}

public class App {
    public static void main(String[] args) {
        Worker worker = new Worker();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
    }
}
