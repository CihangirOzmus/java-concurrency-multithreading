package threadmanipulation.waitforthreadswithjoin.daemonandworkerthreads;

public class Worker implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Worker thread finished its execution....");
    }
}
