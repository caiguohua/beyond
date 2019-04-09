package com.dharma.api.sba.controller;

import com.dharma.api.sba.bean.Product;
import com.dharma.api.sba.service.ProductService;
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

    @PostMapping("/add/{name}/{price}")
    public String createProduct(@PathVariable String name,@PathVariable Double price){
        return productService.createProduct(name,price);
    }

    @PutMapping("/update/{id}/{name}/{price}")
    public String updateProduct(@PathVariable Integer id, @PathVariable String name, @PathVariable Double price){
        return productService.updateProduct(id,name,price);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
