package com.cgh.spring.jpa.service;

import com.cgh.spring.jpa.model.User;
import com.cgh.spring.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAlluser() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(new User("null","null"));
    }

    public List<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    public boolean addUser(User user){
        return userRepository.save(user) != null;
    }

    public boolean updateUser(User user){
        return userRepository.save(user) != null;
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }
}
