package com.zhp.demo.dao;

import com.zhp.demo.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByPname(String pname);

    Optional<Product> findByPid(Integer pid);

}
