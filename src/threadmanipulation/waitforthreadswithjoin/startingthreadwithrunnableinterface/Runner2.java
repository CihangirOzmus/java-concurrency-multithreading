package threadmanipulation.waitforthreadswithjoin.startingthreadwithrunnableinterface;

public class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("startingthread1.Runner2: " + i);
        }
    }

}
