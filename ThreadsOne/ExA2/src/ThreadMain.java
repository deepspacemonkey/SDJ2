import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("String1");
        list.add("String2");
        Adding adding = new Adding("A", 1000, list);
        Thread thread = new Thread(adding);
        thread.start();
        synchronized (thread) {
            while(thread.isAlive())
                thread.wait();
        }
        System.out.println("MAIN FINISH");
        System.out.println(list);
    }
}
