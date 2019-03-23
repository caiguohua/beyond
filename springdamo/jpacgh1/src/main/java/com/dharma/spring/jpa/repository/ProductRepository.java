package com.dharma.spring.jpa.repository;

import com.dharma.spring.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
