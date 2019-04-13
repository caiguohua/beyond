package com.zhp.demo.controller;

import com.zhp.demo.bean.Order;
import com.zhp.demo.bean.Product;
import com.zhp.demo.bean.User;
import com.zhp.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getOrders();
    }

    @GetMapping("/oid/{oid}")
    public Order getOrderById(@PathVariable Integer oid){
        return orderService.getOrderByOid(oid);
    }

    @GetMapping("/user/oid/{oid}")
    public User getUserByOrderOid(@PathVariable Integer oid){
        return orderService.getUsreByOrderOid(oid);
    }

    @GetMapping("/product/oid/{oid}")
    public Product getProductByOrderOid(@PathVariable Integer oid){
        return orderService.getProductByOrderOid(oid);
    }

    @GetMapping("/pinfo/{oid}")
    public List<Map<String,Object>> getOrderInfoByOid(@PathVariable Integer oid){return orderService.getOrderInfoByOrderOid(oid);}

    @GetMapping("/uinfo/{oid}")
    public List<Map<String,Object>> getOrderInfo(@PathVariable Integer oid){return orderService.getOrderInfoByOid(oid);}

//    @GetMapping("/orderinfo")
//    public OrderInfo getOrderInfoByOid(){return orderInfoService.getOrderInfoByOrderOid();}

}
