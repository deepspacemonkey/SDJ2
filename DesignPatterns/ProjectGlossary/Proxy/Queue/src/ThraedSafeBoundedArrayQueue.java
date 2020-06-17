public class ThraedSafeBoundedArrayQueue<Type> implements QueueADT<Type> {
    private ArrayQueue<Type> arrayQueue;
    private int capacity;

    public ThraedSafeBoundedArrayQueue(int capacity) {
        this.capacity = capacity;
        arrayQueue = new ArrayQueue<Type>(capacity);
    }

    @Override
    public synchronized void enqueue(Type element) throws IllegalAccessException {
        if(isFull())
            throw new IllegalAccessException("Queue is full");
        else
            arrayQueue.enqueue(element);
    }

    @Override
    public synchronized Type dequeue() {
        return arrayQueue.dequeue();
    }

    @Override
    public synchronized Type first() {
        return arrayQueue.first();
    }

    @Override
    public synchronized int indexOf(Type element) {
        return arrayQueue.indexOf(element);
    }

    @Override
    public synchronized boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    @Override
    public synchronized boolean isFull() {
        return size() == capacity;
    }

    @Override
    public synchronized int size() {
        return arrayQueue.size();
    }

    @Override
    public synchronized int capacity() {
        return capacity;
    }

    public String toString() {
        return arrayQueue.toString();
    }
}
