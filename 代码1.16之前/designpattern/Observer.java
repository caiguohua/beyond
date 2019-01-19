package designpattern;

/**
 * 观察者模式
 */

import java.util.ArrayList;
import java.util.List;

interface IPublisher{
    void register(ISubscriber subscriber); //注册

    void unregister(ISubscriber subscriber); //取消关注

    void notifySubscribers(); //通知用户

    Object getUpdate(ISubscriber subscriber);
}

interface ISubscriber{
    void update();

    void setPublisher(IPublisher publisher);

}

class MyPublisher implements IPublisher{

    private List<ISubscriber> subscribers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyPublisher() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void register(ISubscriber subscriber) {
        if(subscriber == null){
            throw new NullPointerException("invalid subscriber");
        }

        synchronized (MUTEX){
            if(!subscribers.contains(subscriber)){
                subscribers.add(subscriber);
                subscriber.setPublisher(this);
            }
        }
    }

    @Override
    public void unregister(ISubscriber subscriber) {
        synchronized (MUTEX){
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers() {
        List<ISubscriber> subscriberLocal;

        synchronized (MUTEX){
            if(!changed){
                return;
            }

            subscriberLocal = new ArrayList<>(this.subscribers);

            this.changed = false;
        }
        for(ISubscriber sub : subscriberLocal){
            sub.update();
        }
    }

    @Override
    public Object getUpdate(ISubscriber subscriber) {
        System.out.println(subscriber.toString() + "received message");
        return this.message;
    }

    public void publish(String msg){
        System.out.println("message::" + msg + " published");
        this.message = msg;
        this.changed = true;
        notifySubscribers();
    }
}

class MyTopicSubscriber implements ISubscriber{

    private String name;
    private IPublisher topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String)topic.getUpdate(this);
        if(msg == null){
            System.out.println(name + ":: no new message");
        }else{
            System.out.println(name + ":: consuming message::" + msg);
        }
    }

    @Override
    public void setPublisher(IPublisher publisher) {
        this.topic = publisher;
    }
}

public class Observer {
    public static void main(String[] args) throws InterruptedException {
        MyPublisher publisher = new MyPublisher();

        ISubscriber tom = new MyTopicSubscriber("tom");
        ISubscriber jerry = new MyTopicSubscriber("jerry");
        ISubscriber leng = new MyTopicSubscriber("leng");

        publisher.register(tom);
        publisher.register(jerry);
        publisher.register(leng);

        publisher.publish("welcome to dharma world");
        Thread.sleep(3000);
        publisher.publish("dharma java design-pattern started");
    }
}
