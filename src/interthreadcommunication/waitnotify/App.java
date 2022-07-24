package interthreadcommunication.waitnotify;

class Process {
    public void produce() throws InterruptedException {
       synchronized (this) {
           System.out.println("Running produce method...");
           wait();
           System.out.println("Again in the producer method...");
       }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consume method is executed...");
            notify();
        }
    }
}

public class App {
    public static void main(String[] args) {
        Process process = new Process();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
