public class WashingHallTest {
    public static void main(String[] args) {
        WashingHall washingHall = new WashingHall(3);
        Display display = new Display(washingHall);

        new Thread(display).start();

        for (int i = 0; i < 20; i++) {
            new Thread(new Car(i, washingHall)).start();
        }
    }
}
