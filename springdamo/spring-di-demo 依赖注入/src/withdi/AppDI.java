package withdi;

import withdi.consumer.Consumer;
import withdi.injector.EmailServiceInjector;
import withdi.injector.ServiceInjector;
import withdi.injector.SmsServiceInjector;

public class AppDI {
    public static void main(String[] args) {
        String msg = "Hi Dharma";
        String email = "cgh@dharma.com";
        String phone = "12345678910";
        ServiceInjector injector;
        Consumer app;

        //发邮件
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.process(msg,email);

        //发短信
        injector = new SmsServiceInjector();
        app = injector.getConsumer();
        app.process(msg,phone);
    }
}
