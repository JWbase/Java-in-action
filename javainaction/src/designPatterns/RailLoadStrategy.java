package designPatterns;

public class RailLoadStrategy implements MoveStrategy{
    @Override
    public void move() {
        System.out.println("선로를 통해 이동");
    }
}
