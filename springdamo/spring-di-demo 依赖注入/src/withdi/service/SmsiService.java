package withdi.service;

public class SmsiService implements Service {
    @Override
    public void send(String msg, String rec) {
        System.out.println("Sms sent to " + rec + "with message " + msg);
    }
}
