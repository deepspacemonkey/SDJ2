package via.sdj2.threads;

public class Counter {
    private long value = 0;

    public Counter() {
    }

    public void inc() {
        synchronized (this) {
            value++;
        }
    }

    public long value(){
        synchronized (this) {
            return value;
        }
    }
}
