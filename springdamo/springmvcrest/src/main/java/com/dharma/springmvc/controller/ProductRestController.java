package com.dharma.springmvc.controller;

import com.dharma.springmvc.domain.Product;
import com.dharma.springmvc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<String>("Welcome to dharma mall", HttpStatus.OK);
    }

    //Retrieve
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productService.getProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        System.out.println("Fetching Product with id " + id);
        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }


    //Create
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Product " + product.getName());

        if (productService.isProductExist(product)) {
            System.out.println("A Product with name " + product.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        productService.addProduct(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Update
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        System.out.println("Updating Product " + id);

        Product currentProduct = productService.getProductById(id);

        if (currentProduct == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setCount(product.getCount());

        productService.updateProduct(currentProduct);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }

    //Delete
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Product with id " + id);

        Product product = productService.getProductById(id);
        if (product == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.deleteProductById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAllProducts() {
        System.out.println("Deleting All Products");

        productService.deleteAllProducts();
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

}
