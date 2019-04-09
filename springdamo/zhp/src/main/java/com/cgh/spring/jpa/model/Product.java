package com.cgh.spring.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private int amount;

    public Product() {
    }

    public Product(String pname, Double price, int amount) {
        this.pname = pname;
        this.price = price;
        this.amount = amount;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
