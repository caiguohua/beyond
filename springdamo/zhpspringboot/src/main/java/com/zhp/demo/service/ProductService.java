package com.zhp.demo.service;

import com.zhp.demo.bean.Product;
import com.zhp.demo.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public String createProduct(String name,Double price,Integer count){
        Product product = new Product(-1, name,price,count);
        productDao.save(product);
        return "create success!";
    }

    public String updateProduct(Integer id,String name,Double price,Integer count){
        Product product = new Product(id,name,price,count);
        productDao.save(product);
        return "update success!";
    }

    public List<Product> getProducts(){
        return productDao.findAll();
    }

    public Product getProductById(Integer id){
        return productDao.findByid(id).orElse(new Product("null",0.0,0));
    }

    public List<Product> getProductByName(String name){
        return productDao.findByname(name);
    }

    public void deleteById(Integer id){
        productDao.deleteById(id);
    }


}
