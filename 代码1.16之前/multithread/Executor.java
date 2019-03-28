package multithread;

public class Executor {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new BasicRunnable(),"t1");
        Thread t2 = new Thread(new BasicRunnable(),"t2");
        System.out.println("Starting...");
        t1.start();
        t1.join();
        t2.start();
        System.out.println("Started");


        Thread t3 = new BasicThread("t3");
        Thread t4 = new BasicThread("t4");
        System.out.println("Starting...");
        t3.start();
        t3.join();
        t4.start();
        System.out.println("Started");
    }
}
