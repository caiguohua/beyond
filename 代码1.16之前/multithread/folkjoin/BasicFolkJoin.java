package multithread.folkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Order extends RecursiveTask<String>{

    private int order;

    public Order(int order) {
        this.order = order;
    }

    public String getOrder(int order) {
        return " [" + order + "] ";
    }

    @Override
    protected String compute() {


        StringBuilder result = new StringBuilder();

        if(order < 5){
            return this.getOrder(order);
        }

        List<RecursiveTask<String>> forks = new ArrayList<>();

        for(int i = 0; i < this.order; i++){
            Order subTask = new Order(i);
            subTask.fork();
            forks.add(subTask);
        }

        for(RecursiveTask<String> subTask:forks){
            result.append(subTask.join());
        }

        return result.toString();
    }
}

public class BasicFolkJoin {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Order task = new Order(5);
        String result = pool.invoke(task);
        System.out.println("Order: " + result);
    }

}
