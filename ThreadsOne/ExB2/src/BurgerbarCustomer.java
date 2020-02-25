import static java.lang.Thread.sleep;

public class BurgerbarCustomer implements Runnable{
    private int burgersToEat;
    private String name;
    private Burgerbar burgerbar;

    public BurgerbarCustomer(int burgersToEat, String name, Burgerbar burgerbar) {
        this.burgersToEat = burgersToEat;
        this.name = name;
        this.burgerbar = burgerbar;
    }


    @Override
    public void run() {
        for (int i = 0; i < burgersToEat; i++) {
            burgerbar.eatBurger(name);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
