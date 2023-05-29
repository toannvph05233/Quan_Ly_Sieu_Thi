package controller;

import model.Product;
import services.ProductService;
import view.CustomerView;
import view.LoginView;
import view.ProductView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController {
    private ProductView ProductView;
    private LoginView loginView;
    private ProductService productService;
    private CustomerView customerView;

    public ProductController(ProductView ProductView, LoginView loginView, CustomerView customerView) {
        this.loginView =loginView;
        this.ProductView = ProductView;
        this.customerView = customerView;
        this.productService = new ProductService();
        ProductView.addListProductSelectionListener(new ListProductSelectionListener());
        ProductView.addAddProductListener(new AddProductListener());
        ProductView.addClearProductListener(new ClearProductListener());
        ProductView.addEditProductListener(new EditProductListener());
        ProductView.addDeleteProductListener(new DeleteProductListener());
        ProductView.backProductListener(new BackProductListener());
        ProductView.addManagerCustomerListener(new ManagerCustomerListener());
        ProductView.showListProducts(productService.getProducts());

    }


    class ListProductSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ProductView.fillProductFromSelectedRow();
        }
    }


    class AddProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product Product = ProductView.getProductInfo();
            if (Product != null) {
                productService.add(Product);
                ProductView.showListProducts(productService.getProducts());
                ProductView.showMessage("Thêm thành công!");
            }
        }
    }


    class EditProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product Product = ProductView.getProductInfo();
            if (Product != null) {
                productService.edit(Product);
                ProductView.showListProducts(productService.getProducts());
                ProductView.showMessage("Sửa thành công!");
            }
        }
    }


    class ClearProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ProductView.clearProductInfo();
        }
    }

    class BackProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ProductView.setVisible(false);
            loginView.setVisible(true);
        }
    }
    class ManagerCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ProductView.setVisible(false);
            customerView.setVisible(true);
        }
    }


    class DeleteProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product Product = ProductView.getProductInfo();
            if (Product != null) {
                productService.delete(Product);
                ProductView.showListProducts(productService.getProducts());
                ProductView.showMessage("Xóa thành công!");
            }
        }
    }
}
