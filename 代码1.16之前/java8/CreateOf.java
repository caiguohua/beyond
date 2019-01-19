package java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateOf {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("im'm cgh");
        stream.forEach(System.out::println);
//        stream.forEach(s -> System.out.println(s +'l'));


        Stream<String> stream1 = Stream.of("java","python","C#","go");
        stream1.forEach(s -> System.out.println("<<"+s+ ">>"));
//        stream1.forEach(System.out::println);


        String[] names = {"web","imperative","declarative","functional"};
        Stream<String> stream2 = Stream.of(names);
        stream2.forEach(System.out::println);


        Stream<String> stream3 = Arrays.asList(names).stream();
        stream3.forEach(System.out::println);


    }
}
