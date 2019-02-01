package services;

public class EmailService implements Service {
    @Override
    public boolean send(String msg, String rec) {
        System.out.println("Email sent to" + rec + "with Message" + msg);
        return true;
    }
}
