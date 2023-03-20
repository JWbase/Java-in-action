package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExam {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        ArrayList<T> result = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        filter(new ArrayList<>(), nonEmptyStringPredicate);

    }


}
