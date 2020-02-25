public class Burgerbar {
    private int numberOfBurgers;
    private int maxNumberOfBurgers;

    public Burgerbar(int maxNumberOfBurgers){
        this.maxNumberOfBurgers = maxNumberOfBurgers;
        numberOfBurgers = 0;
    }

    public void makeBurger(String employeeName) {
        synchronized (this) {
            while(numberOfBurgers >= maxNumberOfBurgers) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numberOfBurgers++;
            System.out.println("Burger made by " + employeeName + "\n Number of burgers: " + numberOfBurgers);
            notify();
        }
    }

    public void eatBurger(String who) {
        synchronized (this) {
            while(numberOfBurgers <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numberOfBurgers--;
            System.out.println("Burger eaten by " + who + "\n Number of burgers: " + numberOfBurgers);
            notify();
        }
    }

    public int getNumberOfBurgers() {
        return numberOfBurgers;
    }
}
