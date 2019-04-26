package com.zhp.product.zhpproduct.controller;

import com.zhp.product.zhpproduct.bean.Product;
import com.zhp.product.zhpproduct.dao.ProductDao;
import com.zhp.product.zhpproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;

    @GetMapping("/all")
    public List<Product> getAll(){return productService.getProducts();}
    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PostMapping("/add/{name}/{price}/{count}/{tid}")
    public String createProduct(@PathVariable String name, @PathVariable Double price, @PathVariable Integer count, @PathVariable Integer tid){
        return productService.createProduct(name,price,count,tid);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productDao.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productDao.save(product);
    }

    @PutMapping("/update/{id}/{name}/{price}/{count}/{tid}")
    public String updateProduct(@PathVariable Integer id, @PathVariable String name, @PathVariable Double price, @PathVariable Integer count,@PathVariable Integer tid){
        return productService.updateProduct(id,name,price,count,tid);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
    }
}
