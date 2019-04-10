package com.dharma.api.sba.dao;

import com.dharma.api.sba.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    List<Product> findByName(String name);
}
