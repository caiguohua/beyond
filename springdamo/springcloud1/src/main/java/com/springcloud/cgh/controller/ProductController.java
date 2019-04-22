package com.springcloud.cgh.controller;

import com.springcloud.cgh.bean.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("/a")
    public String getAll(){
        Product product = new Product(1,"abc",9.9);
        return "true";
    }

}
