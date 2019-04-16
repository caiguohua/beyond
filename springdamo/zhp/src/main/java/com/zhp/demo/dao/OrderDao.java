package com.zhp.demo.dao;

import com.zhp.demo.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

//    @Query(value = "select * from user where id = :uid",nativeQuery = true)

//    @Query(value = "SELECT o.* FROM order o JOIN user u ON o.uid = u.id WHERE o.uid = id AND u.id = uid",nativeQuery = true)
//    Order findOrderByUserId(Integer id,Integer uid);

    Optional<Order> findByOid(Integer oid);

    @Query(value = "select o.oid,p.id,p.name,p.price,o.money,o.datetime from product p, order_ o where o.oid = :oid and p.id = o.pid",nativeQuery = true)
    List<Map<String,Object>> findPOrderInfoById(@Param("oid") Integer oid);
//    多表联接
//    select p, o from p where p.id = o.id
    @Query(value = "select o.oid,o.money,u.id,u.phone,u.name,u.address from order_ o,user u where o.oid = :oid and u.id = o.uid",nativeQuery = true)
    List<Map<String,Object>> findUOrderInfoById(@Param("oid") Integer oid);

    //@Query(value = "select o.oid,u.id,u.name,p.id,p.name from (order_ o left join user u on  u.id = o.uid) left join product p on p.id = o.pid where o.oid = :oid",nativeQuery = true)
    @Query(value = "select o.oid,o.money,o.uid,o.datetime,u.phone,u.name,u.address,p.pname,p.price from order_ o,user u,product p where o.oid = :oid and u.id = o.uid and p.id = o.pid",nativeQuery = true)
    List<Map<String,Object>> findPUOrderInfoById(@Param("oid") Integer oid);
}
