package com.dharma.spring.jpa.controller;

import com.dharma.spring.jpa.model.Product;
import com.dharma.spring.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody String welcome(){
        return "Welcome to Dharma mall";
    }

    @GetMapping("/product")
    public @ResponseBody
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
