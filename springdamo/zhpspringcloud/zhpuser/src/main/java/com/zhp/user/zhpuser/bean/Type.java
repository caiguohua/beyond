package com.zhp.user.zhpuser.bean;

public class Type {

    private Integer typeid;
    private String typename;

    public Type() {
    }

    public Type(String typename) {
        this.typename = typename;
    }

    public Type(Integer typeid,String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public Integer getId() {
        return typeid;
    }

    public void setId(Integer id) {
        this.typeid = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

}
