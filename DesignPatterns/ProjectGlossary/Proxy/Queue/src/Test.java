public class Test {
    public static void main(String[] args) {
        QueueADT<Integer> queue = new ThraedSafeBoundedArrayQueue<Integer>(10);
        for(int i = 0; i < 13; i++) {
            try {
                queue.enqueue(i);
            } catch (IllegalAccessException e) {
                System.out.println("Queue is full");
            }
        }
        System.out.println(queue);
    }
}
