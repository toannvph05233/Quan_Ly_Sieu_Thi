package services;

import model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService {
    List<Product> products = new ArrayList<>();

    public ProductService(){
        products.add(new Product(1, "CoCa-CoLa", 20, 50,"src/img/coca.jpeg", new Date()));
        products.add(new Product(2, "Bò Húc", 1, 50,"src/img/bohuc.jpeg", new Date()));
    }

    public void add(Product product){
        this.products.add(product);
    }

    public boolean edit(Product product){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()){
                this.products.set(i,product);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Product product){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()){
                this.products.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
