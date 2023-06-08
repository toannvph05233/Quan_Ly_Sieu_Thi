package model;

import java.util.List;

public class NhaCungCap {
    private int id;
    private String name;
    private String address;
    private String phone;
    private List<Product> products;

    public NhaCungCap() {
    }

    public NhaCungCap(int id, String name, String address,String phone, List<Product> products) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.products = products;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
