package generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    public static double sum(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(5);
        ints.add(7);
        ints.add(9);
        ints.add(11);
        System.out.println("Sum of ints is " + sum(ints));
    }
}
