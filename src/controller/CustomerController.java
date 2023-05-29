package controller;

import model.Customer;
import services.CustomerService;
import view.LoginView;
import view.CustomerView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController {
    private CustomerView CustomerView;
    private LoginView loginView;
    private CustomerService CustomerService;

    public CustomerController(CustomerView CustomerView, LoginView loginView) {
        this.loginView =loginView;
        this.CustomerView = CustomerView;
        this.CustomerService = new CustomerService();
        CustomerView.addListCustomerSelectionListener(new ListCustomerSelectionListener());
        CustomerView.addAddCustomerListener(new AddCustomerListener());
        CustomerView.addClearCustomerListener(new ClearCustomerListener());
        CustomerView.addEditCustomerListener(new EditCustomerListener());
        CustomerView.addDeleteCustomerListener(new DeleteCustomerListener());
        CustomerView.backCustomerListener(new BackCustomerListener());
        CustomerView.showListCustomers(CustomerService.getListCustomers());

    }


    class ListCustomerSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            CustomerView.fillCustomerFromSelectedRow();
        }
    }


    class AddCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer Customer = CustomerView.getCustomerInfo();
            if (Customer != null) {
                CustomerService.add(Customer);
                CustomerView.showListCustomers(CustomerService.getListCustomers());
                CustomerView.showMessage("Thêm thành công!");
            }
        }
    }


    class EditCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer Customer = CustomerView.getCustomerInfo();
            if (Customer != null) {
                CustomerService.edit(Customer);
                CustomerView.showListCustomers(CustomerService.getListCustomers());
                CustomerView.showMessage("Sửa thành công!");
            }
        }
    }


    class ClearCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CustomerView.clearCustomerInfo();
        }
    }

    class BackCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CustomerView.setVisible(false);
            loginView.setVisible(true);
        }
    }


    class DeleteCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer Customer = CustomerView.getCustomerInfo();
            if (Customer != null) {
                CustomerService.delete(Customer);
                CustomerView.showListCustomers(CustomerService.getListCustomers());
                CustomerView.showMessage("Xóa thành công!");
            }
        }
    }
}
