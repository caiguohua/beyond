package com.cgh.spring.jpa.controller;

import com.cgh.spring.jpa.model.Order;
import com.cgh.spring.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public @ResponseBody
    List<Order> getAllorder(){
        return orderService.getAllorder();
    }

    @GetMapping("/order/oid/{oid}")
    public @ResponseBody
    Order getOrderById(@PathVariable Long oid){
        return orderService.getOrderByid(oid);
    }

    @PostMapping("/order")
    public HttpStatus addOrder(@RequestBody Order order){
        return  orderService.addOrder(order) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PutMapping("/order")
    public HttpStatus updateOrder(@RequestBody Order order){
        return orderService.UpdateOrder(order) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/order/oid/{oid}")
    public void deleteOrderByOid(@PathVariable Long oid){
        orderService.deleteOrder(oid);
    }

    @DeleteMapping("/order")
    public void deleteAllOrder(){
        orderService.deleteAllOrder();
    }

}
