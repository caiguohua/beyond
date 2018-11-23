package multithread;

public class DameonExecutor {
    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DameonThread(),"dt");
        dt.setDaemon(true);
        dt.start();
        Thread.sleep(3000);
        System.out.println("Fnishing process");
    }
}
