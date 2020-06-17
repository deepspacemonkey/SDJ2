import static java.lang.Thread.sleep;

public class Car implements Runnable {
    private WashingHall washingHall;
    private int id;

    public Car(int id, WashingHall washingHall) {
        this.washingHall = washingHall;
        this.id = id;
    }

    @Override
    public void run() {
        Hall hall = washingHall.enterForWashing();
        System.out.println("Car " + id + " is being washed in " + hall);

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        washingHall.finishWashing(hall);
    }
}
