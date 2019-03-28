package withoutdi;

public class App {
    private EmailService service = new EmailService();

    public void processMessage(String msg,String rec){
        this.service.sendEmail(msg, rec);
    }
}
