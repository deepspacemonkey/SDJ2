package via.sdj2.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();
        CounterUpdater c1 = new CounterUpdater("Updater1", counter, 200000);
        CounterUpdater c2 = new CounterUpdater("Updater2", counter, 200000);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
        System.out.println("Main Thread Ended");

//                        Runnable run = new Runnable();
//        for (int i = 0; i < 20; i++) {
//            Thread thread = new Thread(run);
//            thread.setName("Thread " + i);
//            thread.start();
//        }
//        System.out.println("___________________");
//        executor service
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//        for (int i = 0; i < 20; i++) {
//            Runnable run2 = new Runnable();
//            //start the thread using executor
//            executor.execute(run2);
//        }
//        System.out.println("MAIN END");
    }
}
