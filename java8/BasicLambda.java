package java8;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BasicLambda {
    private static boolean isPrime(int number){
//        if(number < 2){
//            return false;
//        }
//
//        for (int i=2;i < number;i++){
//            if(number % i == 0){
//                return false;
//            }
//        }
//        return true;

        IntPredicate isDivisible = i -> number % i != 0;

        return number > 1 && IntStream.range(2,number).allMatch(isDivisible);

    }

    public static void main(String[] args) {
        System.out.println(isPrime(18));
        System.out.println(isPrime(13));
    }
}
