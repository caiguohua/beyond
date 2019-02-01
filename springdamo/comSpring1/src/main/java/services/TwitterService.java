package services;

public class TwitterService implements Service {
    @Override
    public boolean send(String msg, String rec) {
        System.out.println("Twitter sent to " + rec + "with Message" + msg);
        return true;
    }
}
