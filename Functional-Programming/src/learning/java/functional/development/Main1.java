package learning.java.functional.development;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main1 {

    public static void main(String[] args) {

        Consumer<String> simpleConsumer = System.out::println;
        simpleConsumer.accept("Hello World");
        BiConsumer<String, String> biConsumerWithTwoArguments = (input1, input2) -> {
            System.out.println("Input Value 1: " + input1);
            System.out.println("Input value 2: " + input2);
        };
        biConsumerWithTwoArguments.accept("Hakan", "Yedibela");

        callBackWithConsumer("Hakan", "Yedibela", callBack -> {
            System.out.println("This message will not appear in the console! " + callBack);
        });
        callBackWithConsumer(null, null, System.out::println);
        callBackWithConsumer(null, null, callBack -> {
            System.out.println("With addition " + callBack);
        });
        callBackWithConsumer("Hakan", null, System.out::println);
        callBackWithRunnable("Hakan", "Yedibela", () -> {
            System.out.println("Callback with runnable!");
        });
        callBackWithRunnable("Hakan", null, () -> {
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
