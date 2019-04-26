package com.zhp.user.zhpuser.dao;

import com.zhp.user.zhpuser.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{

    List<User> findByname(String name);

    Optional<User> findByid(Integer id);
}
