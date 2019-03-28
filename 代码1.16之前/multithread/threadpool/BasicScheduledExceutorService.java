package multithread.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable{
    private int taskId;

    public ScheduledTask(int taskId) {
        this.taskId = taskId;
    }


    @Override
    public void run() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Task # " + this.taskId + " run at " + currentDateTime);
    }
}

public class BasicScheduledExceutorService {
    public static void main(String[] args) {
        final int threadPoolSize  = 3;
        ScheduledExecutorService scheduledExceutorService =
                Executors.newScheduledThreadPool(threadPoolSize);
        ScheduledTask task1 = new ScheduledTask(1);
        ScheduledTask task2 = new ScheduledTask(2);

        scheduledExceutorService.schedule(task1,2, TimeUnit.SECONDS);
        scheduledExceutorService.scheduleAtFixedRate(task2,0,10,TimeUnit.SECONDS);

        try{
            TimeUnit.SECONDS.sleep(25);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        scheduledExceutorService.shutdown();
    }
}
