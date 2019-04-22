package com.dharma.cgh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //服务器
public class SpringcouldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcouldApplication.class, args);
    }

}
