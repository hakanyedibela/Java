package learning.java.functional.development;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main0 {

    public static void main(String[] args) {

        /**
         * Simple Function in Java. First Integer is the parameter
         * and second Integer is the return type of the Function.
         */
        Function<Integer, Integer> addTwoSameIntegers = x -> x + x;
        Integer resultTwoSame = addTwoSameIntegers.apply(3);
        System.out.println(resultTwoSame);

        /**
         * Call function in Class
         */
        Function<Integer, Integer> callMyCalculator = MyCalculator::multiplyWithFive;
        Integer resultMyMultiplyer = callMyCalculator.apply(4);
        System.out.println(resultMyMultiplyer); // 20

        /**
         * Simple BiFunction in Java. The first and second Integer are the parameters
         * and third Integer parameter is the return type of the BiFunction.
         */
        BiFunction<Integer, Integer, Integer> addTwoDifferentIntegers = Integer::sum;
        Integer resultTwoDifferent = addTwoDifferentIntegers.apply(3, 4);
        System.out.println(resultTwoDifferent);

        /**
         * Call function in Class
         */
        BiFunction<Integer, Integer, Integer> callMyCalculatorWithTwoValues = MyCalculator::multiplyTwoDifferentIntegersWithFiveAndWithTen;
        Integer resultMyTwoValueMultiplyer = callMyCalculatorWithTwoValues.apply(3, 4);
        System.out.println(resultMyTwoValueMultiplyer); // 55

        /**
         * Call custom function in Class
         */
        Function<Integer, Integer> callCustomMultiplyer = MyCalculator.customMultiplyer(5);
        Integer resultCustomMultiplyer = callCustomMultiplyer.apply(5);
        System.out.println(resultCustomMultiplyer); // 25
    }


    static class MyCalculator {

        static Integer multiplyWithFive(Integer x) {
            return x * 5;
        }

        static Integer multiplyTwoDifferentIntegersWithFiveAndWithTen(Integer x, Integer y) {
            return x * 5 + y * 10; // Dot for Point with or without brackets
        }

        static Function<Integer, Integer> customMultiplyer(Integer y) {
            return x -> x * y; // This function returns a function. The Lambda Syntax -> means return
        }
    }
}
