public class WashingHall {
    private QueueADT<Hall> availableHalls;
    private int occupiedHalls;
    private boolean queueChanged;

    public WashingHall(int numberOfWashingHalls) {
        availableHalls = new ArrayQueue<>(numberOfWashingHalls);
        queueChanged = false;

        for (int i = 0; i < numberOfWashingHalls; i++) {
            availableHalls.enqueue(new Hall(i));
        }
    }

    public synchronized Hall enterForWashing() {
        while (availableHalls.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Hall hall = availableHalls.dequeue();
        queueChanged = true;
        occupiedHalls++;
        notifyAll();
        return hall;
    }

    public synchronized void finishWashing(Hall hall) {
        while (availableHalls.isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availableHalls.enqueue(hall);
        queueChanged = true;
        notifyAll();
    }

    public synchronized int getFreePlaces() {
        while (!queueChanged) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queueChanged = false;
        int places = availableHalls.size();
        notifyAll();
        return places;
    }
}
