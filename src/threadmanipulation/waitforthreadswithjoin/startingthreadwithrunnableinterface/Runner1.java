package threadmanipulation.waitforthreadswithjoin.startingthreadwithrunnableinterface;

public class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("startingthread1.Runner1: " + i);
        }
    }

}
