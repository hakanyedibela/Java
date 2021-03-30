package learning.java.functional.development;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main0 {

    public static void main(String[] args) {

        Function<Integer, Integer> addTwoSameIntegers = x -> x + x;
        Integer resultTwoSame = addTwoSameIntegers.apply(3);
        System.out.println(resultTwoSame);

        Function<Integer, Integer> callMyCalculator = MyCalculator::multiplyWithFive;
        Integer resultMyMultiplier = callMyCalculator.apply(4);
        System.out.println(resultMyMultiplier); // 20

        BiFunction<Integer, Integer, Integer> addTwoDifferentIntegers = Integer::sum;
        Integer resultTwoDifferent = addTwoDifferentIntegers.apply(3, 4);
        System.out.println(resultTwoDifferent);

        BiFunction<Integer, Integer, Integer> callMyCalculatorWithTwoValues = MyCalculator::multiplyTwoDifferentIntegersWithFiveAndWithTen;
        Integer resultMyTwoValueMultiplier = callMyCalculatorWithTwoValues.apply(3, 4);
        System.out.println(resultMyTwoValueMultiplier); // 55

        Function<Integer, Integer> callCustomMultiplyer = MyCalculator.customMultiplyer(5);
        Integer resultCustomMultiplyer = callCustomMultiplyer.apply(5);
        System.out.println(resultCustomMultiplyer); // 25
    }


    static class MyCalculator {

        static Integer multiplyWithFive(Integer x) {
            return x * 5;
        }

        static Integer multiplyTwoDifferentIntegersWithFiveAndWithTen(Integer x, Integer y) {
            return x * 5 + y * 10;
        }

        static Function<Integer, Integer> customMultiplyer(Integer y) {
            return x -> x * y;
        }
    }
}
