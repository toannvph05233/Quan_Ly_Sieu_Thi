package view;

import model.NhanVien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JLabel title;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;
    private JButton registerBtn;


    // Tạo đường dẫn đến tập tin ảnh
    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userNameLabel = new JLabel("UserName");
        passwordlabel = new JLabel("Password");
        title = new JLabel("Login Quản Lý ");
        Font font = new Font("Arial", Font.BOLD, 28);
        title.setFont(font);

        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();
        registerBtn = new JButton();

        loginBtn.setText("Login");
        registerBtn.setText("Register");
        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);

        ImageIcon imageIcon = new ImageIcon("src/img/sieuthi.jpeg");
        Image image = imageIcon.getImage();
        // Đặt kích thước mới cho ảnh
        int newWidth = 400;
        int newHeight = 300;
        Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        // Tạo ImageIcon từ ảnh đã thay đổi kích thước
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);


        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(400, 300);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(title);
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(registerBtn);
        panel.add(img);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, title, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, title, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 80, SpringLayout.WEST, userNameLabel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginBtn, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, loginBtn, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, registerBtn, 150, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, registerBtn, 150, SpringLayout.NORTH, panel);


        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Login");
        this.setSize(400, 300);
        this.setResizable(false);
        setLocationRelativeTo(null);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public NhanVien getUser() {
        return new NhanVien(userNameField.getText(),
                String.copyValueOf(passwordField.getPassword()));
    }

    public void actionPerformed(ActionEvent e) {
    }
    
    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }
    public void showRegisterView(ActionListener listener) {
        registerBtn.addActionListener(listener);
    }
}