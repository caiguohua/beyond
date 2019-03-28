package consumer;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import services.Service;

@Component
public class AnnoApp {

    @Autowired
    private Service service;

    public boolean process(String msg,String rec){
        return this.service.send(msg, rec);
    }
}
