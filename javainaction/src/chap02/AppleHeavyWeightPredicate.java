package chap02;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        //150 초과하는 사과만 리턴
        return apple.getWeight() > 150;
    }
}
