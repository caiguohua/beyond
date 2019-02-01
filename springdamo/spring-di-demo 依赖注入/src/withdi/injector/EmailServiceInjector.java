package withdi.injector;

import withdi.consumer.AppDi;
import withdi.consumer.Consumer;
import withdi.service.EmailService;

public class EmailServiceInjector implements ServiceInjector {
    @Override
    public Consumer getConsumer() {
        AppDi app = new AppDi();
        app.setService(new EmailService());
        return app;
    }
}
