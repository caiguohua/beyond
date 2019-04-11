package com.zhp.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class OrderInfo implements Serializable {

    @Autowired
    private Integer orderid;
    private Integer userid;
    private String username;
    private String productname;
    private Double productprice;
    private String userphone;
    private String useraddress;

    public OrderInfo() {
    }

    public OrderInfo(Integer orderid, Integer userid, String username, String productname, Double productprice, String userphone, String useraddress) {
        this.orderid = orderid;
        this.userid = userid;
        this.username = username;
        this.productname = productname;
        this.productprice = productprice;
        this.userphone = userphone;
        this.useraddress = useraddress;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", userphone='" + userphone + '\'' +
                ", useraddress='" + useraddress + '\'' +
                '}';
    }
}
