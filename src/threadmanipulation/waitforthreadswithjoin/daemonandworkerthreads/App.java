package threadmanipulation.waitforthreadswithjoin.daemonandworkerthreads;

public class App {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new Worker());

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}
