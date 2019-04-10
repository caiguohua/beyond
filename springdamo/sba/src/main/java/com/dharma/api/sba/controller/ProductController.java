package com.dharma.api.sba.controller;

import com.dharma.api.sba.bean.Product;
import com.dharma.api.sba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getProducts();
    }


    @Cacheable(value = "product",key = "#id",unless = "#result.price > 5000")
    @GetMapping("/get/{id}")
    public Product getById(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @GetMapping("/get/name/{name}")
    public List<Product> getByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }

    @PostMapping("/add/{name}/{price}")
    public String createProduct(@PathVariable String name,@PathVariable Double price){
        return productService.createProduct(name,price);
    }

    @CachePut(value = "product",key = "#id")
    @PutMapping("/update/{id}/{name}/{price}")
    public Product updateProduct(@PathVariable Integer id, @PathVariable String name, @PathVariable Double price){
        return productService.updateProduct(id,name,price);
    }

    @CacheEvict(value = "product",allEntries = true)
    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
