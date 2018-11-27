package multithread;

public class DameonThread implements Runnable {
    @Override
    public void run() {
        while (true){
            processing();
        }
    }

    private void processing() {
        System.out.println("processing dameon task");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
