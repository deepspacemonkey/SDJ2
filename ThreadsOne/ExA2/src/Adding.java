import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Adding implements java.lang.Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            list.add(id + i);
            System.out.println(list);
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String id;
    private long sleepTime;
    private ArrayList<String> list;

    public Adding(String id, long sleepTime, ArrayList<String> list) {
        this.id = id;
        this.sleepTime = sleepTime;
        this.list = list;
    }
}
