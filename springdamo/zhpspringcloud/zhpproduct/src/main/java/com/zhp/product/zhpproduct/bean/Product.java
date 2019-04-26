package com.zhp.product.zhpproduct.bean;


import com.netflix.discovery.provider.Serializer;

import javax.persistence.*;
import java.lang.annotation.Annotation;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private Integer count;

    @Column
    private Integer tid;

//    @ManyToOne(fetch = FetchType.LAZY )  //cascade = CascadeType.REFRESH, optional = false
//    @JoinColumn(name = "tid",referencedColumnName="typeid",insertable=false, updatable=false)  //referencedColumnName="id",
//    private Type type;

    public Product() {
    }

    public Product(String name, Double price, Integer count, Integer tid) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.tid = tid;
    }

    public Product(Integer id,String name, Double price, Integer count, Integer tid, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.tid = tid;
//        this.type = type;
    }

    public Product(Integer id,String name, Double price, Integer count, Integer tid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

//    public Type getType() {
//        return type;
//    }
//
//    public void setType(Type type) {
//        this.type = type;
//    }

}
