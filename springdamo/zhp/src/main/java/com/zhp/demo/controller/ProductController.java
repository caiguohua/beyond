package com.zhp.demo.controller;

import com.zhp.demo.bean.Product;
import com.zhp.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
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

    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PostMapping("/add/{name}/{price}/{count}")
    public String createProduct(@PathVariable String name,@PathVariable Double price,@PathVariable Integer count){
        return productService.createProduct(name,price,count);
    }

    @PutMapping("/update/{id}/{name}/{price}/{count}")
    public String updateProduct(@PathVariable Integer id, @PathVariable String name, @PathVariable Double price, @PathVariable Integer count){
        return productService.updateProduct(id,name,price,count);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }

}
