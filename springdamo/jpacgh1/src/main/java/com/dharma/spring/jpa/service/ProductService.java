package com.dharma.spring.jpa.service;

import com.dharma.spring.jpa.model.Product;
import com.dharma.spring.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
}
