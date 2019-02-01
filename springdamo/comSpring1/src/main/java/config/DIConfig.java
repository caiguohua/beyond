package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.EmailService;
import services.Service;

@Configuration
@ComponentScan(value = {"consumer"})

public class DIConfig {

    @Bean
    public Service getService(){
        return new EmailService();
    }
}
