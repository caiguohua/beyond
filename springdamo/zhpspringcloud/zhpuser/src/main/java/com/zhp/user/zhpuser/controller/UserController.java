package com.zhp.user.zhpuser.controller;

import com.zhp.user.zhpuser.bean.User;
import com.zhp.user.zhpuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getUsers();
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public List<User> getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/add/{name}/{sex}/{phone}/{address}")
    public String createUser(@PathVariable String name,@PathVariable Integer sex,@PathVariable String phone,@PathVariable String address){
        return userService.createUser(name,sex,phone,address);
    }

    @PutMapping("/update/{id}/{name}/{sex}/{phone}/{address}")
    public String updateUser(@PathVariable Integer id, @PathVariable String name, @PathVariable Integer sex,@PathVariable String phone,@PathVariable String address){
        return userService.updateUser(id,name,sex,phone,address);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteById(id);
    }
}
