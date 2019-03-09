package com.dao;

import com.pojo.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class StudentDao {
   public List<StudentEntity> query(){
       Session session = null;
       List<StudentEntity> list = null;
       try{
           Configuration conf = new Configuration().configure();

           SessionFactory sf = conf.buildSessionFactory();

           session = sf.openSession();

           String name = "cgh";

           String sql = "select * from student p where p.name like '%"+name+"%'";

           NativeQuery query = session.createSQLQuery(sql);
           list = query.list();
           }catch (HibernateException e){
           e.printStackTrace();
           return null;
       }finally {
           if(session !=null){
               session.close();
           }
       }
       return list;
   }
}


