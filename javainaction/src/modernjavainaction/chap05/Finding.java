package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static modernjavainaction.chap04.Dish.menu;

public class Finding {
    public static void main(String[] args) {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        System.out.println(isaBoolean());
        System.out.println(isNoneMatch());
        System.out.println(getOptionalDish());

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(findFirst(someNumbers));

    }

    private static Optional<Integer> findFirst(List<Integer> someNumbers) {
        return someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
    }

    private static Optional<Dish> getOptionalDish() {
        return menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }

    private static boolean isNoneMatch() {
        return menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
    }

    private static boolean isaBoolean() {
        return menu.stream()
                .allMatch(dish -> dish.getCalories() < 900);
    }
}
