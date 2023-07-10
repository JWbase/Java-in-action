package designPatterns;

public class Moving {
    private MoveStrategy moveStrategy;

    public void move() {
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
