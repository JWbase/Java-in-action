package chap02;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accepter(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
