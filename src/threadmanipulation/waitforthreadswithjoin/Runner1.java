package threadmanipulation.waitforthreadswithjoin;

public class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Runner1:" + 1);
        }
    }

}
