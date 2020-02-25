package via.sdj2.threads;

public class CounterUpdater implements java.lang.Runnable {
    private String name;
    private int updates;
    private Counter counter;

    public void run() {
        for (int i = 0; i < updates; i++) {
            counter.inc();
        }
        System.out.println(counter.value() + " " + name);
    }

    public CounterUpdater(String name, Counter counter, int updates) {
        this.name = name;
        this.updates = updates;
        this.counter = counter;
    }
}
