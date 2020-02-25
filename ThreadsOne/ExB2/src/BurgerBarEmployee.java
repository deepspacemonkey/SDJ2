import static java.lang.Thread.sleep;

public class BurgerBarEmployee implements Runnable {
    private String name;
    private Burgerbar burgerbar;

    public BurgerBarEmployee(String name, Burgerbar burgerbar) {
        this.name = name;
        this.burgerbar = burgerbar;
    }

    @Override
    public void run() {
        while(true){
            burgerbar.makeBurger(name);
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
