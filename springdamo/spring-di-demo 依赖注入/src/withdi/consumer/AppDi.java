package withdi.consumer;

import withdi.service.Service;

public class AppDi implements Consumer {
    private Service service;

    public AppDi(Service service) {
        this.service = service;
    }

    public AppDi() {
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void process(String msg, String rec) {
        this.service.send(msg,rec);
    }
}
