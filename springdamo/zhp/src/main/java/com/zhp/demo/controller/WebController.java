package com.zhp.demo.controller;

import com.zhp.demo.bean.Order;
import com.zhp.demo.bean.Product;
import com.zhp.demo.bean.User;
import com.zhp.demo.service.OrderService;
import com.zhp.demo.service.ProductService;
import com.zhp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/p")
    public String product(ModelMap map){
        List<Product> productList = productService.getProducts();
        map.put("products",productList);
        return "products";
    }

    @RequestMapping("/u")
    public String user(ModelMap map){
        List<User> userList = userService.getUsers();
        map.put("users",userList);
        return "users";
    }

    @RequestMapping("/o")
    public String order(ModelMap map){
        List<Order> orderList = orderService.getOrders();
        map.put("orders",orderList);
        return "orders";
    }

    @RequestMapping("/puo")
    public String puorder(ModelMap map){
        List<Map<String,Object>> puorderList = orderService.getPUOrderInfoByOid(1);
        map.put("puorders",puorderList);
        return "puorders";
    }
}
