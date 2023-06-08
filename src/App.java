import controller.*;
import view.*;

import java.awt.EventQueue;


public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                ProductView productView = new ProductView();
                RegisterView registerView = new RegisterView();
                CustomerView customerView = new CustomerView();
                NhanVienView nhanVienView = new NhanVienView();
                NhaCungCapView nhaCungCapView = new NhaCungCapView();

                LoginController controller = new LoginController(view, registerView, productView, nhanVienView);
                RegisterController registerController = new RegisterController(view,registerView);
                ProductController productController = new ProductController(productView,view,customerView);
                CustomerController customerController = new CustomerController(customerView,view,productView);
                NhanVienController nhanVienController = new NhanVienController(nhanVienView, view, nhaCungCapView);
                NhaCungCapController nhaCungCapController = new NhaCungCapController(nhaCungCapView, nhanVienView);
                controller.showLoginView();
            }
        });
    }
}