package interthreadcommunication.producerconsumerpattern;

public class App {
    public static void main(String[] args) {
        Processor process = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
