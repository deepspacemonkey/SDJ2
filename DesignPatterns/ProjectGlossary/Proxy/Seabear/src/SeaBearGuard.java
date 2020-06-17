public class SeaBearGuard implements VisitSeaBear {
    private SeaBear seaBear;

    public SeaBearGuard() {
        seaBear = new SeaBear();
    }

    @Override
    public void view(String personType) {
        seaBear.view(personType);
    }

    @Override
    public void feed(String personType) {
        if(personType.equals("zookeeper"))
            seaBear.feed(personType);
        else
            System.out.println("You shall not pass!");
    }

    @Override
    public void pet(String personType) {
        if(personType.equals("kiddo"))
            seaBear.pet(personType);
        else
            System.out.println("You shall not pass!");
    }
}
