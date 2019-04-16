package com.zhp.demo.bean;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    public Product(Integer id, String pname, Double price, Integer count) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
