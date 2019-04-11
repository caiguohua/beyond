/**
 * Repository �����ݷ��ʶ���Ľӿڣ���spring data jpa�п���ֱ�Ӽ̳�JpaRepository��
 * ��ʱ����Ҫдʵ�ַ��࣬�ò��൱�ھ��������е�Dao�㣨һ���ж�Ӧ��ʵ���ࣩ���÷����൱
 * ��Mybatis�е�Mapper��ͨ��ʵ�������xml���ú�ע�����ַ�ʽ��������JDBC�е�Dao
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
