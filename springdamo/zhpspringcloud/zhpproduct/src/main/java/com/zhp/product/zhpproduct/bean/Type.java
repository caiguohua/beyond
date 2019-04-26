package com.zhp.product.zhpproduct.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeid;

    @Column
    private String typename;

//    @OneToMany(fetch = FetchType.LAZY )//,mappedBy = "Type",cascade = CascadeType.ALL
//    @JoinColumn(name = "tid")
//    @OrderBy(value = "id ASC")
//    private List<Product> product;

    public Type() {
    }

    public Type(String typename) {
        this.typename = typename;
    }

    public Type(Integer typeid,String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }


//    public Type(Integer typeid,String typename, List<Product> product) {
//        this.typeid = typeid;
//        this.typename = typename;
//        this.product = product;
//    }

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

//    public List<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(List<Product> product) {
//        this.product = product;
//    }
}
