package com.cgh.spring.jpa.controller;

import com.cgh.spring.jpa.model.Product;
import com.cgh.spring.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody String welcome(){
        return "Welcome to cghzhp";
    }

    @GetMapping("/product")
    public @ResponseBody
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/pid/{pid}")
    public @ResponseBody
    Product getProductById(@PathVariable Long pid){
        return productService.getProductById(pid);
    }

    @GetMapping("product/pname/{pname}")
    public @ResponseBody
    List<Product> getProductByName(@PathVariable String pname){
        return productService.getProductByName(pname);
    }

    @PostMapping("/product")
    public HttpStatus inertProduct(@RequestBody Product product){
        return productService.addProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PutMapping("/product")
    public HttpStatus updateProduct(@RequestBody Product product){
        return productService.updateProduct(product) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/product/pid/{pid}")
    public HttpStatus delectProductById(@PathVariable Long pid){
        productService.deleteProduct(pid);
        return HttpStatus.NO_CONTENT;
    }

    @DeleteMapping("/product")
    public HttpStatus delectAllProduct(){
        productService.deleteAllProduct();
        return HttpStatus.NO_CONTENT;
    }

//    @GetMapping("/isproduct/pid/{pid}")
//    public @ResponseBody
//    boolean isProductExistById(@PathVariable Long pid){
//        return productService.isProductExistById(pid);
//    }
//
//    @GetMapping("/isproduct/pid/{pname}")
//    public @ResponseBody
//    boolean isProductExistById(@PathVariable String pname){
//        return productService.isProductExistByName(pname);
//    }

}
