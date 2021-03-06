package com.dharma.springmvc.domain;


public class Product {

    private long id;

    private String name;

    private double price;

    private int count;

    public Product() {
        id = 0;
    }

    public Product(long id, String name, double price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Product <id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", count=" + count + ">";
    }
}
