public class SeaBear implements VisitSeaBear {
    @Override
    public void view(String personType) {
        System.out.println("SeaBear looks at " + personType + " and farts");
    }

    @Override
    public void feed(String personType) {
        System.out.println("SeaBear comes to " + personType + " and eats all of your Cheeseburgers");
    }

    @Override
    public void pet(String personType) {
        System.out.println("SeaBear starts to purr due to " + personType);
    }
}
