package com.zhp.demo.dao;

import com.zhp.demo.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends JpaRepository<Order,Integer> {

//    @Query(value = "select * from user where id = :uid",nativeQuery = true)

//    @Query(value = "SELECT o.* FROM order o JOIN user u ON o.uid = u.id WHERE o.uid = id AND u.id = uid",nativeQuery = true)
//    Order findOrderByUserId(Integer id,Integer uid);

    Optional<Order> findByOid(Integer oid);


}
