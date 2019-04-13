package com.zhp.demo.controller;

import com.zhp.demo.bean.Product;
import com.zhp.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/pid/{pid}")
    public Product getProductById(@PathVariable Integer pid){
        return productService.getProductById(pid);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PostMapping("/add/{name}/{price}/{count}")
    public String createProduct(@PathVariable String name,@PathVariable Double price,@PathVariable Integer count){
        return productService.createProduct(name,price,count);
    }

    @PutMapping("/update/{pid}/{name}/{price}/{count}")
    public String updateProduct(@PathVariable Integer pid, @PathVariable String name, @PathVariable Double price, @PathVariable Integer count){
        return productService.updateProduct(pid,name,price,count);
    }

    @DeleteMapping("delete/{pid}")
    public void deleteProduct(@PathVariable Integer pid){
        productService.deleteById(pid);
    }
}
