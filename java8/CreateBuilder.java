package java8;

import java.util.stream.Stream;

public class CreateBuilder {
    public static void main(String[] args) {
        Stream.<String>builder()
                .add("web")
                .add("Desktop")
                .add("Mobile")
                .add("Design")
                .add("DB")
                .build()
                .forEach(System.out::println);

    }
}
