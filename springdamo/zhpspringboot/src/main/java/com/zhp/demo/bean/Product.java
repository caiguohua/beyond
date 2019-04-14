package com.zhp.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column
    private String pname;

    @Column
    private Double price;

    @Column
    private Integer count;

    public Product() {
    }

    public Product(String pname, Double price, Integer count) {
        this.pname = pname;
        this.price = price;
        this.count = count;
    }

    public Product(Integer pid,String pname, Double price, Integer count) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return pid;
    }

    public void setId(Integer id) {
        this.pid = id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String name) {
        this.pname = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
