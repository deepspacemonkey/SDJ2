public class QueueListBased<Type> implements QueueADT<Type> {
    private ListADT<Type> list;

    public QueueListBased() {
        list = new CircularLinkedList<Type>();
    }

    @Override
    public void enqueue(Type element) {
        list.add(element);
    }

    @Override
    public Type dequeue() {
        return list.remove(0);
    }

    @Override
    public Type first() {
        return list.get(0);
    }

    @Override
    public int indexOf(Type element) {
        return list.indexOf(element);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.isFull();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int capacity() {
        return -1;
    }

    public String toString() {
        return list.toString();
    }
}
