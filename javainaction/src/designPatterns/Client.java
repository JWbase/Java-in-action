package designPatterns;

public class Client {
    public static void main(String[] args) {
        Train train = new Train();
        Bus bus = new Bus();

        train.setMoveStrategy(new LoadStrategy());
        bus.setMoveStrategy(new RailLoadStrategy());

        train.move();
        bus.move();
    }
}
