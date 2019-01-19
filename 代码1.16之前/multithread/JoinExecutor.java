package multithread;

public class JoinExecutor {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new BasicRunnable(), "t1");
        Thread t2 = new Thread(new BasicRunnable(), "t2");
        Thread t3 = new Thread(new BasicRunnable(), "t3");

        t1.start();
        t1.join(5000);
        t2.start();
        t2.join();
        t3.start();

        //t3.join();
        System.out.println("hello");
    }
}
