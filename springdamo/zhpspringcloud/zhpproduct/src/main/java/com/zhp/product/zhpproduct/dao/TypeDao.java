package com.zhp.product.zhpproduct.dao;

import com.zhp.product.zhpproduct.bean.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeDao extends JpaRepository<Type,Integer>{

    Optional<Type> findBytypeid(Integer typeid);
}
