package com.cgh.spring.jpa.service;

import com.cgh.spring.jpa.model.Order;
import com.cgh.spring.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllorder()
    {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderByid(Long oid){
        return orderRepository.findByOid(oid).orElse(new Order());
    }

    public boolean addOrder(Order order){
        return orderRepository.save(order) != null;
    }

    public boolean UpdateOrder(Order order){
        return orderRepository.save(order) != null;
    }

    @Transactional
    public void deleteOrder(Long oid){
        orderRepository.delete(oid);
    }

    public void deleteAllOrder(){orderRepository.deleteAll();
    }
}
