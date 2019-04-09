package com.cgh.spring.jpa.controller;

import com.cgh.spring.jpa.model.Product;
import com.cgh.spring.jpa.model.User;
import com.cgh.spring.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public @ResponseBody
    List<User> getAlluser(){
        return userService.getAlluser();
    }

    @GetMapping("/user/id/{id}")
    public @ResponseBody
    User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/name/{name}")
    public @ResponseBody
    List<User> getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/user")
    public HttpStatus addUser(@RequestBody User user){
        return userService.addUser(user) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @PutMapping("/user")
    public HttpStatus updateUser(@RequestBody User user){
        return userService.updateUser(user) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/user/id/{id}")
    public HttpStatus deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return HttpStatus.NO_CONTENT;
    }

    @DeleteMapping("/user")
    public HttpStatus deleteAllUser(){
        userService.deleteAllUser();
        return HttpStatus.NO_CONTENT;
    }
}
