package collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class LoopList {

    public static void main(String[] args) {
        List<String> stocks = new ArrayList<>();
        stocks.add("Google");
        stocks.add("Facebook");
        stocks.add("Microsoft");
        stocks.add("Apple");

        //1
//        Consumer<Object> consumer = new LoopList().new MyConsumer();
//        stocks.forEach(consumer);

        //2
        stocks.forEach(x -> System.out.println("Consumer " + x));

        //3
        stocks.forEach(System.out::println);
    }

//    class MyConsumer implements Consumer<Object>{
//
//        @Override
//        public void accept(Object o) {
//            System.out.println("Consumer " + o);
//        }
//    }
}
