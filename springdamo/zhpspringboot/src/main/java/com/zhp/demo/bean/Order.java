package com.zhp.demo.bean;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "order_")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    @Column
    private Integer uid;

    @Column
    private Integer pid;

    @Column
    private Double money;

    @Column
    private Date datetime;

    public Order() {
    }

    public Order(Integer uid, Integer pid, Double money, Date datetime) {
        this.uid = uid;
        this.pid = pid;
        this.money = money;
        this.datetime = datetime;
    }

    public Order(Integer oid,Integer uid, Integer pid, Double money, Date datetime) {
        this.oid = oid;
        this.uid = uid;
        this.pid = pid;
        this.money = money;
        this.datetime = datetime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

//    @ManyToOne
//    @JoinColumn(name = "user")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }


    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

//    @ManyToOne
//    @JoinColumn(name = "user")
//    public User getUser(){
//        return ;
//    }
}
