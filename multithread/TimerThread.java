package multithread;

import java.util.Date;
import java.util.TimerTask;

public class TimerThread extends TimerTask {
    @Override
    public void run() {
        System.out.println("Timer task started at: " + new Date());
        process();
        System.out.println("timer task ended at: " + new Date());
    }

    private void process() {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
