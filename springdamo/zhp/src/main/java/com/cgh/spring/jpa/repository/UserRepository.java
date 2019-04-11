package com.cgh.spring.jpa.repository;

import com.cgh.spring.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByName(String name);

    Optional<User> findById(Long id);
}
