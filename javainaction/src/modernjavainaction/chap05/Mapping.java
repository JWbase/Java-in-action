package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static modernjavainaction.chap04.Dish.menu;

public class Mapping {

    public static void main(String[] args) {
        //map
        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
        System.out.println("dishNames = " + dishNames);

        //단어가 포함하는 글자의 수를 반환
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println("wordLengths = " + wordLengths);

        // 각 요리명의 길이를 알고 싶을 때 다른 map 메서드를 연결할수있음
        List<Integer> dishNameLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println("dishNameLengths = " + dishNameLengths);

        //스트림 평면화
        List<String> words2 = Arrays.asList("Hello", "World");
        List<String> uniqueCharacters = words2.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println("uniqueCharacters = " + uniqueCharacters);

        //리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환
        List<Integer> root = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integers = root.stream()
                .map(integer -> integer * integer)
                .collect(toList());
        System.out.println("integers = " + integers);

        //두 개의 숫자 리스트가 있을 때 모든 숫자 쌍의 리스트를 반환
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(toList());

        collect.forEach(i -> System.out.println(Arrays.toString(i)));


        //합이 3으로 나누어떨어지는 쌍만 반환
        numbers1.stream()
                .flatMap(i ->
                        numbers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> new int[]{i, j})
                )
                .collect(toList());
    }


}
