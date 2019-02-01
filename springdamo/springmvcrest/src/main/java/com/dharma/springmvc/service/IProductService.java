package com.dharma.springmvc.service;

import com.dharma.springmvc.domain.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(long id);

    Product getProductByName(String name);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(long id);

    List<Product> getProducts();

    void deleteAllProducts();

    public boolean isProductExist(Product product);

}
