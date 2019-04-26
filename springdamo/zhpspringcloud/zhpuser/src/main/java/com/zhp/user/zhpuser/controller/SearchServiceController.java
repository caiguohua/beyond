package com.zhp.user.zhpuser.controller;

import com.zhp.user.zhpuser.ProductClient;
import com.zhp.user.zhpuser.TypeClient;
import com.zhp.user.zhpuser.bean.Product;
import com.zhp.user.zhpuser.bean.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchServiceController {

    @Autowired
    ProductClient productClient;

    @Autowired
    TypeClient typeClient;

    @GetMapping
    public String hello(){return "Welcome to cgh zhp!";}

    @RequestMapping(value = "/find/product/{productId}" , method = RequestMethod.GET)
    public Product findProductById(@PathVariable Integer productId){
        System.out.println("Getting Product details for " + productId);
        return productClient.getProductById(productId);
    }

    @RequestMapping(value = "/find/type/{typeId}" , method = RequestMethod.GET)
    public Type findTypeById(@PathVariable Integer typeId){
        System.out.println("Getting Type details for " + typeId);
        return typeClient.getTypeById(typeId);
    }

    @RequestMapping(value = "/add/product" , method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        return productClient.createProduct(product);
    }

    @RequestMapping(value = "/update/product" , method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        return productClient.updateProduct(product);
    }

    @RequestMapping(value = "/add/type" , method = RequestMethod.POST)
    public Type  addType(@RequestBody Type type){
        return typeClient.createType(type);
    }

    @RequestMapping(value = "/update/type" , method = RequestMethod.PUT)
    public Type updateType(@RequestBody Type type){
        return typeClient.updateType(type);
    }

    @RequestMapping(value = "/delete/product/{productId}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Integer productId){
        productClient.deleteProduct(productId);
    }

    @RequestMapping(value = "/delete/type/{typeId}",method = RequestMethod.DELETE)
    public void deleteType(@PathVariable Integer typeId){
        typeClient.deleteType(typeId);
    }
}
