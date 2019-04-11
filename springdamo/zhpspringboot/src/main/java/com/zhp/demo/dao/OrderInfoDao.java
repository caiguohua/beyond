package com.zhp.demo.dao;

import com.zhp.demo.bean.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderInfoDao extends JpaRepository<OrderInfo,Integer> {

//    @Query(value = "SELECT u.*,p.* FROM ")
//    Optiona<OrderInfo> findByid(Integer uid,Integer pid);

//    @Query(value = "select u.id, u.phone,u.name, u.address,p.name,p.price from user u, product p"
//            + " where u.id = :uid and"
//            + " p.id = :pid",nativeQuery = true)
//    List<OrderInfo> findOrerInfoById(@Param("uid") Integer uid,@Param("pid") Integer pid);


    @Query(value = "select u.id, u.phone,u.name, u.address,p.name,p.price from user u, product p"
            + " where u.id = ?1 and"
            + " p.id = ?1",nativeQuery = true)
    OrderInfo f();
}
