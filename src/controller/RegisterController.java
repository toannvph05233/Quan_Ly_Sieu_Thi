package controller;


import model.NhanVien;

import services.NhanVienService;
import view.CustomerView;
import view.LoginView;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private NhanVienService userDao;
    private LoginView loginView;
    private RegisterView registerView;

    private CustomerView customerView;
    public RegisterController(LoginView view, RegisterView registerView) {
        this.loginView = view;
        this.registerView = registerView;
        this.userDao = new NhanVienService();
        registerView.addRegisterListener(new RegisterListener());
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NhanVien user = registerView.getUser();
            if (userDao.checkUserName(user)) {
                userDao.add(user);
                loginView.setVisible(true);
                registerView.setVisible(false);
            } else {
                registerView.showMessage("username đang bị trùng hoặc để trống");
            }
        }
    }
}
