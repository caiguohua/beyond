package withdi.injector;

import withdi.consumer.AppDi;
import withdi.consumer.Consumer;
import withdi.service.SmsiService;

public class SmsServiceInjector implements ServiceInjector {
    @Override
    public Consumer getConsumer() {
        AppDi app = new AppDi();
        app.setService(new SmsiService());
        return app;
    }
}
