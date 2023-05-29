package model;

import java.util.Date;

public class Product {
    private int id;
    private static int countId = 2;
    private String name;
    private double price;
    private int count;
    private Date date = new Date();

    public Product() {
    }

    public Product(int id, String name, double price, int count, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.date = date;
    }

    public Product(String name, double price, int count, Date date) {
        this.id = ++ countId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product(int id, String name, double price, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    @Override
    public String toString() {
        return name;
    }
}
