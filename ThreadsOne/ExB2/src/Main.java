import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Burgerbar burgerbar = new Burgerbar(10);
        ArrayList<Thread> threads = new ArrayList<Thread>();
        threads.add(new Thread(new BurgerBarEmployee("Bim", burgerbar)));
        threads.get(0).setDaemon(true);
        threads.add(new Thread(new BurgerBarEmployee("Job", burgerbar)));
        threads.get(1).setDaemon(true);
        for (int i = 0; i < 5; i++) {
            threads.add((new Thread(new BurgerbarCustomer(i*3, "Customer " + i, burgerbar))));
//            threads.get(i).setDaemon(true);
        }

        for(Thread thread : threads)
            thread.start();

        for (int i = 2; i < 7; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
