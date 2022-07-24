package interthreadcommunication.intrinsiclock;

public class App {
    public static int counter1 = 0;
    public static int counter2 = 0;

    public static void increment1() {
        synchronized (App.class) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (App.class) {
            counter2++;
        }
    }

    //will work slower because App has only one intrinsic-lock
    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment2();
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

        System.out.println("The counter1: " + counter1);
        System.out.println("The counter2: " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
