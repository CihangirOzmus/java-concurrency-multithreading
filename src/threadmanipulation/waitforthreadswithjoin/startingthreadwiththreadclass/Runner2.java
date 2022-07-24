package threadmanipulation.waitforthreadswithjoin.startingthreadwiththreadclass;

public class Runner2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Runner2: " + i);
        }
    }

}
