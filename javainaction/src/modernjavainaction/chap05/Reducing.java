package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modernjavainaction.chap04.Dish.menu;

//리듀싱 -> 모든 스트림요소를 처리해서 하나의 값으로 반환
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("product = " + product);

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);
        System.out.println("max = " + max);

        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);
        System.out.println("min = " + min);

        int countMenu = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println("countMenu = " + countMenu);


    }
}
