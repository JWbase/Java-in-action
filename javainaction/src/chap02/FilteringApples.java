package chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chap02.Color.*;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED),
                new Apple(160, RED)
        );

        List<Apple> greenApples = filterAppleByColor(inventory, GREEN);
        List<Apple> redApples = filterAppleByColor(inventory, RED);

        System.out.println(greenApples);
        System.out.println(redApples);

        //모든 속성 사용방법
        List<Apple> greenApples2 = filterApples(inventory, GREEN, 150, false);
        System.out.println("greenApples2 : " + greenApples2);

        //Predicate를 이용해서 동작을 파라미터 화
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        System.out.println("redAndHeavyApples : " + redAndHeavyApples);
        
        //prettyPrintApple 메서드 구현 후 출력
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    // 초록색 사과면 list에 넣고 반환
    // 만약 초록색사과가 아니라 빨간색 사과를 필터하고 싶으면???
    // 비슷한 코드가 반복 존재하면 그 코드를 추상화 하는게 맞음!
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 색깔을 파라미터로 받아서 메소드를 생성
    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    //무게 정보도 추가된 메소드
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    //모든 속성을 메서드 파라미터로 추가
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color) || (!flag && apple.getWeight() > weight))) {
                result.add(apple);
            }
        }
        return result;
    }

    //Predicate를 이용한 사과를 필터링 하는 메소드
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    //유연한 prettyPrintApple 메서드 구현하기
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            String output = appleFormatter.accepter(apple);
            System.out.println(output);
        }
    }
}
