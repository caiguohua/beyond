package com.springcloud.cgh.controller;

import com.springcloud.cgh.ProductClient;
import com.springcloud.cgh.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchServiceController {

    @Autowired
    ProductClient productClient;

    @GetMapping
    public String hello(){return "Dharma Java Adventure";}

    @RequestMapping(value = "/find/{productId}",method = RequestMethod.GET)
    public Product findProductById(@PathVariable int productId){
        System.out.println("Getting Product details for " + productId);

        return productClient.getProductById(productId);
    }
}
