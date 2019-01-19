package java8;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class BasicOptionalStream {
    public static void main(String[] args) {
        OptionalInt maxOdd = IntStream.of(11,20,9,40)
                .filter(n -> n%2 == 1)
                .max();

//        if(maxOdd.isPresent()){
//            System.out.println(maxOdd.getAsInt());
//        }else {
//            System.out.println("not exists");
//        }

        System.out.println(maxOdd.orElse(-1));
    }
}
