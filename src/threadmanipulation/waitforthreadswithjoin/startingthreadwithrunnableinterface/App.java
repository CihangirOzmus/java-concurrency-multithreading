package threadmanipulation.waitforthreadswithjoin.startingthreadwithrunnableinterface;

public class App {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        // this is multithreading, controlled by single core and help of time slicing.
        // no parallel execution here
        t1.start();
        t2.start();

        // alternative declaration I
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                System.out.println("Runner3: " + i);
            }
        });

        t3.start();

        // alternative declaration II
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runner4: " + i);
            }
        });

        t4.start();
    }

}
