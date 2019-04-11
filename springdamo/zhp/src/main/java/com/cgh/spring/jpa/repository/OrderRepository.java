package com.cgh.spring.jpa.repository;

import com.cgh.spring.jpa.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface OrderRepository extends CrudRepository<Order,Long> {

    //@Query(value = "select * from order_ where oid = :oid",nativeQuery = true)
    Optional<Order> findByOid(Long oid);
}
