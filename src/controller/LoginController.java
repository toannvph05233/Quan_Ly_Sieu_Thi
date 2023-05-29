package controller;import model.NhanVien;import services.NhanVienService;import view.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;public class LoginController {    //    private UserFunc userDao;    private LoginView loginView;    private RegisterView registerView;    private NhanVienService nhanVienService;    private ProductView productView;    private NhanVienView nhanVienView;    public LoginController(LoginView view, RegisterView registerView, ProductView productView, NhanVienView nhanVienView) {        this.loginView = view;        this.registerView = registerView;        this.productView = productView;        this.nhanVienView = nhanVienView;        this.nhanVienService = new NhanVienService();        view.addLoginListener(new LoginListener());        view.showRegisterView(new RegisterListener());    }    public void showLoginView() {        loginView.setVisible(true);    }    /**     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"     *     * @author viettuts.vn     */    class LoginListener implements ActionListener {        public void actionPerformed(ActionEvent e) {            NhanVien nhanVien = loginView.getUser();            if (nhanVien.getUserName().equals("admin") && nhanVien.getPassword().equals("admin")) {                nhanVienView.showListNhanViens(NhanVienService.nhanViens);                nhanVienView.setVisible(true);                loginView.setVisible(false);                return;            }            NhanVien nhanVienLogin = nhanVienService.checkLogin(nhanVien);            if (nhanVienLogin != null) {                productView.setVisible(true);                loginView.setVisible(false);            } else {                loginView.showMessage("username hoặc password không đúng.");            }        }    }    class RegisterListener implements ActionListener {        public void actionPerformed(ActionEvent e) {            loginView.setVisible(false);            registerView.setVisible(true);        }    }}