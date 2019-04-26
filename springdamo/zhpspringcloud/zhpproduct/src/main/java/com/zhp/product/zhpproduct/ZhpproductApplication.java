package com.zhp.product.zhpproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZhpproductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhpproductApplication.class, args);
    }

}
