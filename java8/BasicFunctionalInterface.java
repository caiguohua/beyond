package java8;

import java.util.function.Consumer;

public class BasicFunctionalInterface {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer2 = System.out::println;
        consumer.andThen(consumer2).accept("bloody java8");
    }
}
