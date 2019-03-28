package com.how2java.test;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.management.Query;
import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s =sf.openSession();
        s.beginTransaction();

        //插入
//        for(int i = 0;i < 10; i++){
//            Product p = new Product();
//            p.setName("iphone"+i);
//            p.setPrice(i);
//            s.save(p);
//        }
//
//        Product p1 = new Product();
//        p1.setName("xiaomi8");
//        p1.setPrice(6000);
//        s.save(p1);

//        Product p =(Product) s.get(Product.class,1);
//        s.delete(p);

        //sql查询
        String name = "xiaomi";
//
        String sql = "select * from product_ p where p.name like '%"+name+"%'";
//
        NativeQuery q = s.createSQLQuery(sql);
        List<Object[]> list = q.list();
        for(Object[] os : list){
            for(Object filed : os){
                System.out.println(filed+"\t");
            }
            System.out.println();
        }


//        System.out.println("id = 2 的产品名字是："+p.getName());

//        //多对一
//        Category c = new Category();
//        c.setName("c1");
//        s.save(c);
//
//        Product p = (Product) s.get(Product.class,8);
//        p.setCategory(c);
//        s.update(p);
//
//        s.getTransaction().commit();
//        s.close();
//        sf.close();
   }
}
