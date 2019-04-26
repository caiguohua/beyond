package com.zhp.user.zhpuser.bean;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer sex;

    @Column
    private String phone;

    @Column
    private String address;

    public User() {
    }

    public User(String name, Integer sex, String phone, String address) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }

    public User(Integer id,String name, Integer sex, String phone, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
