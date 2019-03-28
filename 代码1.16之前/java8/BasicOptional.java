package java8;

import java.util.Optional;

public class BasicOptional {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty);

//        String myName = "cgh";
        String myName = null;
//        Optional<String> str = Optional.of(myName);
        Optional<String> str = Optional.ofNullable(myName);
//        System.out.println(str);
//        System.out.println(str.get());
        System.out.println(str.orElse("lanhua"));
    }
}
