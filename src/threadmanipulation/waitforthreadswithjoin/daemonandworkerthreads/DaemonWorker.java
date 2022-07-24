package threadmanipulation.waitforthreadswithjoin.daemonandworkerthreads;

public class DaemonWorker implements Runnable{
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Daemon thread is running...");
        }

    }
}
