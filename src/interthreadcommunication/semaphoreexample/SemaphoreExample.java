package interthreadcommunication.semaphoreexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// singleton pattern
enum Downloader {
    INSTANCE;

    private final Semaphore semaphore = new Semaphore(3, true);

    public void download () {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data from the web...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class SemaphoreExample {
    public static void main(String[] args) {
        // create multiple threads with executors
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }
}
