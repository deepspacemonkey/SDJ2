public class Test {
    public static void main(String[] args) {
        QueueADT<Integer> list = new QueueListBased<Integer>();
        for (int i = 0; i < 13; i++) {
            list.enqueue(i);
        }
        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            list.dequeue();
        }
        System.out.println(list);
    }
}
