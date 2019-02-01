package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.Service;

@Component
public class XMLApp {
    @Autowired
    private Service service;

    public void setService(Service service){
        this.service = service;
    }

    public boolean process(String msg,String rec){
        return this.service.send(msg, rec);
    }
}
