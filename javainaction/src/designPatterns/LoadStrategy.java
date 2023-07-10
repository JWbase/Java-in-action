package designPatterns;

public class LoadStrategy implements MoveStrategy{
    @Override
    public void move() {
        System.out.println("도로를 통해 이동");
    }
}
