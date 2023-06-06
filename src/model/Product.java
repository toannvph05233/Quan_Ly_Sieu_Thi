package model;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private int id;
    private static int countId = 2;
    private String name;
    private double price;
    private int count;
    private String img = "src/img/coca.jpeg";
    private Date date = new Date();

    public Product() {
    }

    public Product(int id, String name, double price, int count, String img, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.date = date;
        if (checkImg(img)){
            this.img = img;
        }else {
            this.img = "src/img/vodanh.png";
        }

    }

    public Product(String name, double price, int count, String img, Date date) {
        this.id = ++countId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.date = date;
        if (checkImg(img)){
            this.img = img;
        }else {
            this.img = "src/img/vodanh.png";
        }
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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


    public boolean checkImg(String img) {
        Pattern pattern = Pattern.compile("^src/img/[\\w.-]+\\.(jpg|jpeg|png|gif)$");
        Matcher matcher = pattern.matcher(img);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
