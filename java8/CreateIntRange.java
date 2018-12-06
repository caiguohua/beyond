package java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateIntRange {
    public static void main(String[] args) {
        IntStream.range(1,10).forEach(System.out::println);

        Stream.empty().forEach(System.out::println);

        Stream.generate(CreateIntRange::next)
                .limit(100)
                .forEach(System.out::println);
    }


    static int i =0;

    private static int next() {
        return ++i;
    }
}
