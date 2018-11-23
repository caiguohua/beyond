package multithread;

class DLThread implements Runnable{
    private Object obj1;
    private Object obj2;

    public DLThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String name= Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on" + obj1);
        synchronized (obj1){
            System.out.println(name+" acquiring lock on" + obj1);
            work();
            System.out.println(name+" acquiring lock on" + obj2);
            synchronized (obj2){
                System.out.println(name+" acquiring lock on" + obj2);
                work();
            }
            System.out.println(name + " released lock on" + obj2);
        }
        System.out.println(name+" acquiring lock on" + obj1);
        System.out.println(name+" finished task");

    }

    private void work() {
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class DeadLockAnalysis{
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new DLThread(obj1,obj2),"t1");
        Thread t2 = new Thread(new DLThread(obj2,obj3),"t2");
        Thread t3 = new Thread(new DLThread(obj3,obj1),"t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }
}