package com.zhp.product.zhpproduct.dao;

import com.zhp.product.zhpproduct.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

    List<Product> findByname(String name);

    Optional<Product> findById(Integer id);
}
