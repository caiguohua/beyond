package com.dharma.api.sba.service;

import com.dharma.api.sba.bean.Product;
import com.dharma.api.sba.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public String createProduct(String name,Double price){
        Product product = new Product(-1, name,price);
        productDao.save(product);
        return "create success!";
    }

    public Product updateProduct(Integer id,String name,Double price){
        Product product = new Product(id,name,price);
        productDao.save(product);
//        return "update success!";
        return product;
    }


    public List<Product> getProducts(){
        return productDao.findAll();
    }

    public Product getProduct(Integer id){
        return productDao.findById(id).orElse(new Product("null",0.0));
    }

    public List<Product> getProductsByName(String name){
        return productDao.findByName(name);
    }

    public void deleteById(Integer id){
        productDao.deleteById(id);
    }


}
