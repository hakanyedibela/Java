package learning.java.functional.development;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main1 {

    public static void main(String[] args) {

        /**
         * Simple Consumer Function, is a void function that takes just one
         * argument.
         */
        Consumer<String> simpleConsumer = (value) -> System.out.println(value);
        simpleConsumer.accept("Hello World");

        BiConsumer<String, String> biConsumerWithTwoArguments = (input1, input2) -> {
            // Do something useful here
            System.out.println("Input Value 1: " + input1);
            System.out.println("Input value 2: " + input2);
        };

        biConsumerWithTwoArguments.accept("Hakan", "Yedibela");

        /**
         * Callback Function with Consumer like in JavaScript
         */
        callBackWithConsumer("Hakan", "Yedibela", callBack -> {
            // Do something useful here
            System.out.println("This message will not appear in the console! " + callBack);
        });

        callBackWithConsumer(null, null, System.out::println);

        callBackWithConsumer(null, null, callBack -> {
            // Do something useful here
            System.out.println("With addition " + callBack);
        });

        callBackWithConsumer("Hakan", null, System.out::println);


        /**
         * Callback with Runnable like in JavaScript
         */
        callBackWithRunnable("Hakan", "Yedibela", () -> {
            // Do something useful here
            System.out.println("Callback with runnable!");
        });

        callBackWithRunnable("Hakan", null, () -> {
            // Do something useful here
            System.out.println("Callback with runnable!");
        });

    }


    static void callBackWithConsumer(String firstName, String lastName, Consumer<String> callback) {

        if (firstName != null) {
            System.out.println(firstName);
        } else {
            callback.accept("John");
        }

        if (lastName != null) {
            System.out.println(lastName);
        } else  {
            callback.accept("Doe");
        }
    }


    static void callBackWithRunnable(String firstName, String lastName, Runnable callback) {

        if (firstName != null) {
            System.out.println(firstName);
        } else {
            callback.run();
        }

        if (lastName != null) {
            System.out.println(lastName);
        } else  {
            callback.run();
        }
    }
}
