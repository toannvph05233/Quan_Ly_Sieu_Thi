package services;


import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * StudentFunc class
 *
 * @author viettuts.vn
 */
public class CustomerService {
    private List<Customer> listCustomers = new ArrayList<>();

    public CustomerService() {
        this.listCustomers.add(new Customer(1,"Nguyễn Văn Toàn", (byte) 20,"Quảng Ninh","0999999999"));
        this.listCustomers.add(new Customer(2,"Nguyễn Thị Hương", (byte) 25,"Hà Nội","0987654321"));
    }


    public void add(Customer customer) {
        this.listCustomers.add(customer);
    }



    public void edit(Customer customer) {
        for (int i = 0; i < listCustomers.size(); i++) {
            if (listCustomers.get(i).getId() == customer.getId()){
                listCustomers.set(i, customer);
            }
        }
    }


    public boolean delete(Customer customer) {
        Customer customer1 = findById(customer.getId());
        if (customer1 != null) {
            listCustomers.remove(customer);
            return true;
        }
        return false;
    }

    public Customer findById(int id) {
        for (Customer c : listCustomers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Customer> findAllByName(String name) {
        List<Customer> customers = new ArrayList<>();
        for (Customer c : listCustomers) {
            if (c.getName().contains(name)) {
                customers.add(c);
            }
        }
        return customers;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortCustomerByName() {
        Collections.sort(listCustomers, new Comparator<Customer>() {
            public int compare(Customer customer1, Customer customer2) {
                return customer1.getName().compareTo(customer2.getName());
            }
        });
    }

    public List<Customer> getListCustomers() {
        return listCustomers;
    }

    public void setListCustomers(List<Customer> listCustomers) {
        this.listCustomers = listCustomers;
    }
}
