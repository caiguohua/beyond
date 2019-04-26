package com.zhp.product.zhpproduct.service;

import com.zhp.product.zhpproduct.bean.Type;
import com.zhp.product.zhpproduct.dao.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeDao typeDao;

    public List<Type> getAll(){return typeDao.findAll();}

    public Type getBytypeId(Integer typeid){
        return typeDao.findBytypeid(typeid).orElse(new Type("null"));
    }

    public String createType(String typename){
        Type type = new Type(-1,typename);
        typeDao.save(type);
        return "create success!";
    }

    public String updateType(Integer id,String typename){
        Type type = new Type(id,typename);
        typeDao.save(type);
        return "update success!";
    }

    public void deleteById(Integer id){
        typeDao.deleteById(id);
    }
}
