package threadmanipulation.waitforthreadswithjoin.startingthreadwiththreadclass;

public class App {

    public static void main(String[] args) {
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();

        t1.start();
        t2.start();

        System.out.println("Threads are finished.");
    }

}