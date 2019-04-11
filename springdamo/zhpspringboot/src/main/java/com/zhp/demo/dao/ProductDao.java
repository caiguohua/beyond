package com.zhp.demo.dao;

import com.zhp.demo.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByname(String name);

    Optional<Product> findByid(Integer id);

}
