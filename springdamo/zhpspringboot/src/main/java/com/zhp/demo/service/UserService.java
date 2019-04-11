package com.zhp.demo.service;

import com.zhp.demo.bean.User;
import com.zhp.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String createUser(String name,Integer sex,String phone,String address){
        User user = new User(-1, name,sex,phone,address);
        userDao.save(user);
        return "create success!";
    }

    public String updateUser(Integer id,String name,Integer sex,String phone,String address){
        User user = new User(id,name,sex,phone,address);
        userDao.save(user);
        return "update success!";
    }

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public User getUserById(Integer id){
        return userDao.findByid(id).orElse(new User("null",0,"null","null"));
    }

    public List<User> getUserByName(String name){
        return userDao.findByname(name);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }
}
