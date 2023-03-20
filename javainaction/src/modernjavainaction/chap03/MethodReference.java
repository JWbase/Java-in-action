package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;


        //생성자 레퍼런스로 생성자의 레퍼런스 만들기
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        //위 코드는 풀어서 보면 아래와 같다
        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();

        //생성자 레퍼런스로 생성자의 레퍼런스 만들기
        Function<Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(110);

        Function<Integer, Apple> c4 = (weight) -> new Apple(weight);
        Apple a4 = c4.apply(110);

        //map 메서드를 사용해서 Apple 생성자로 전달하기
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }
}
