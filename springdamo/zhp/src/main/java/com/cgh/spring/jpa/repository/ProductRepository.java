/**
 * Repository 是数据访问对象的接口，在spring data jpa中可以直接继承JpaRepository，
 * 此时不需要写实现方类，该层相当于经典代码层中的Dao层（一般有对应的实现类），该方法相当
 * 于Mybatis中的Mapper（通常实现类采用xml配置和注解两种方式），或者JDBC中的Dao
 */

package com.cgh.spring.jpa.repository;

import com.cgh.spring.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findByPname(String pname);

    Optional<Product> findByPid(Long pid);

}
