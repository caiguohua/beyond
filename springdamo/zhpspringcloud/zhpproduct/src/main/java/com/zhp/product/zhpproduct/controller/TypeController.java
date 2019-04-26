package com.zhp.product.zhpproduct.controller;

import com.zhp.product.zhpproduct.bean.Product;
import com.zhp.product.zhpproduct.bean.Type;
import com.zhp.product.zhpproduct.dao.TypeDao;
import com.zhp.product.zhpproduct.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private TypeDao typeDao;

    @GetMapping("/all")
    public List<Type> getAll(){return typeService.getAll();}
    @GetMapping("/typeid/{typeid}")
    public Type getTypeBytypeId(@PathVariable Integer typeid){
        return typeService.getBytypeId(typeid);
    }

    @PostMapping("/add/{typename}")
    public String createType(@PathVariable String typename ){
        return typeService.createType(typename);
    }

    @PostMapping
    public Type createType(@RequestBody Type type){return typeDao.save(type);}

    @PutMapping
    public Type updateType(@RequestBody Type type){return typeDao.save(type);}

    @PutMapping("/update/{typeid}{typename}")
    public String updateType(@PathVariable Integer typeid, @PathVariable String typename){
        return typeService.updateType(typeid,typename);
    }

    @DeleteMapping("/{typeid}")
    public void deleteType(@PathVariable Integer typeid){
        typeService.deleteById(typeid);
    }
}
