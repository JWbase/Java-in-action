package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //2011년에 일어난 모든 트랜잭션을 찾아서 값을 오름차순으로 정리
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        //거래자가 근무하는 모든 도시를 중복 없이 나열 하시오.
        List<String> cityList = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("cityList = " + cityList);

        // 케임브릿지에서 거래하는 모든 거래자를 찾아서 이름순으로 정렬
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("cambridge = " + cambridge);

        //모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        String traders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2 + " ");
        System.out.println("traders = " + traders);

        //밀라노에 거래자가 있는가?
        boolean isMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("milan = " + isMilan);

        //전체 트랜잭셩 중 최댓값은 얼마인가?
        Optional<Integer> max = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);
        System.out.println("max = " + max);

        //전체 트랜잭셩 중 최솟값은 얼마인가?
        Optional<Transaction> min = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("min = " + min);

        Optional<Integer> reduceMin = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min);
        System.out.println("reduceMin = " + reduceMin);


    }
}
