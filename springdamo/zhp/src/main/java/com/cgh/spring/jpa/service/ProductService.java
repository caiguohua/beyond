/**
 * service 是服务层接口，在项目中通常情况下都会有对应的实现类以实现业务逻辑，
 * 通常该接口起到承上（controller）启下(repository)的作用,而且该层的实现
 * 类也是代码量和业务复杂度较高的。
 */

package com.cgh.spring.jpa.service;

import com.cgh.spring.jpa.model.Product;
import com.cgh.spring.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long pid) {
        return productRepository
                .findByPid(pid)
                .orElse(new Product("null",0.0,0));
    }

    public List<Product> getProductByName(String pname) {
        return productRepository.findByPname(pname);
    }
//
//    public String isgetProductById(long pid)```````````` {
//        return "exist" /*+ "\n" + productRepository
//                .findByPid(pid)
//                .orElse(new Product("null",0.0,0)) */;
//    }
//
//    public String isgetProductByName(String pname) {
////        return productRepository.findByPname(pname);
//        return "exist" /*+ "\n" + productRepository.findByPname(pname)*/;
//    }


    public boolean addProduct(Product product){
        return productRepository.save(product) != null;
    }

    public boolean updateProduct(Product product) {
        return productRepository.save(product) != null;
    }

//    public boolean isProductExistById(Long pid) {
//        return isgetProductById(pid) !=null;
//    }
//
//    public boolean isProductExistByName(String pname) {
//        return isgetProductByName(pname) !=null;
//    }

    @Transactional
    public void deleteProduct(Long pid) {
        productRepository.delete(pid);
    }

    public void deleteAllProduct(){
        productRepository.deleteAll();
    }
}
