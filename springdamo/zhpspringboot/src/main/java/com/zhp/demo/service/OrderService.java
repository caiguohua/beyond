package com.zhp.demo.service;

import com.zhp.demo.bean.Order;
import com.zhp.demo.bean.OrderInfo;
import com.zhp.demo.bean.Product;
import com.zhp.demo.bean.User;
import com.zhp.demo.dao.OrderDao;
import com.zhp.demo.dao.OrderInfoDao;
import com.zhp.demo.dao.ProductDao;
import com.zhp.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    public List<Order> getOrders(){
        return orderDao.findAll();
    }

    public Order getOrderByOid(Integer oid){
        return orderDao.findByOid(oid)
                .orElse(new Order(0,0,0,0.0,null));
    }

    public User getUsreByOrderOid(Integer oid){
        return userDao.findByid(orderDao.getOne(oid).getUid())
        .orElse(new User("null",0,"null","null"));
    }

    public Product getProductByOrderOid(Integer oid){
        return productDao.findByid(orderDao.getOne(oid).getPid())
                .orElse(new Product(0,"null",0.0,0));
    }



}
