package modernjavainaction.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExam {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        // [7, 2, 6]
        List<Integer> l = map(Arrays.asList("lambdas", "in", "aciton"), (String s) -> s.length());
        System.out.println("l = " + l);
    }

    /**
     * 함수형 인터페이스는 확왼된 예외를 던지는 동작을 허용하지 않음
     * 그러므로 람다를 try ~ catch 블록으로 감싸야한다.
     */
    Function<BufferedReader, String> f = (BufferedReader b) -> {
        try {
            return b.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}
