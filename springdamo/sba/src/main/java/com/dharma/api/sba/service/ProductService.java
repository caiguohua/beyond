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

    public String updateProduct(Integer id,String name,Double price){
        Product product = new Product(id,name,price);
        productDao.save(product);
        return "update success!";
    }

    public List<Product> getProducts(){
        return productDao.findAll();
    }

    public void deleteById(Integer id){
        productDao.deleteById(id);
    }


}
