package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static modernjavainaction.chap04.Dish.menu;

public class Filtering {
    public static void main(String[] args) {
//        프레디케이트로 거름
        System.out.println("Filtering with a predicate");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);

        // 고유 요소로 거름
        System.out.println("Filtering with a elements");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 스트림 슬라이스
        // 칼로리 값을 기준으로 리스트를 오름차순 정렬!
        List<Dish> specialMenu = Arrays.asList(new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        System.out.println("Filtered sorted menu : ");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        filteredMenu.forEach(System.out::println);

        //filter와 달리 각각의 조건에 대해 참이아니면 그 자리에서 멈춘다.
        System.out.println("takeWhile 사용");
        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        sliceMenu1.forEach(System.out::println);

        //takeWhile와 달리 predicate가 처음으로 거짓된 지점까지 발견된 요소를 버림
        System.out.println("dropWhile 사용");
        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        sliceMenu2.forEach(System.out::println);

        // 주어진 값 이하의 크기를 갖는 새로운 스트림 반환
        System.out.println("최대 3개요소 반환");
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        // 요소 건너뛰기
        System.out.println("300칼로리 이상의 첫 두요리를 건너뛰고 반환");
        List<Dish> skipMenu = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        System.out.println("처음 등장하는 고기만 반환");
        List<Dish> skipMeat = specialMenu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());


    }

}
