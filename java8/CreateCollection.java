package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CreateCollection {
    public static void main(String[] args) {
        Stream<String> classes = Arrays.stream(new String[] {"Java","Dharma","2018"});
        classes.forEach(System.out::println);

        Set<String> names = new HashSet<>();
        names.add("Java");
        names.add("Dharma");
        names.add("2018");

        names.forEach(System.out::println);
        names.parallelStream().forEach(System.out::println);
    }
}
