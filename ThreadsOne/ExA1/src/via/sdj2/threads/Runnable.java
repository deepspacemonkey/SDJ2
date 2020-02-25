package via.sdj2.threads;

import static java.lang.Thread.sleep;

public class Runnable implements java.lang.Runnable {

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("I'm inside thread: %s\n", Thread.currentThread().getName());
    }
}
