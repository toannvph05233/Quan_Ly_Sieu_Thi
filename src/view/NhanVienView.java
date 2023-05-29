package view;



import model.NhanVien;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;


public class NhanVienView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addNhanVienBtn;
    private JButton editNhanVienBtn;
    private JButton deleteNhanVienBtn;
    private JButton clearNhanVienBtn;

    private JButton logoutBtn;

    private JScrollPane jScrollPaneNhanVienTable;

    private JTable NhanVienTable;

    private JLabel usernameLabel;
    private JLabel NhanVienLabel;
    private JLabel ageNhanVienLabel;
    private JLabel addressNhanVienLabel;
    private JLabel phoneNhanVienLabel;

    private JTextField usernameField;
    private JTextField NhanVienField;
    private JTextField ageNhanVienField;
    private JTextField addressNhanVienField;
    private JTextField phoneNhanVienField;


    private JLabel titleNhanVienLabel;


    private String[] columnNhanVien = new String[]{
            "Username", "Password", "Age", "Address", "phone"};

    private Object data = new Object[][]{};

    public NhanVienView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addNhanVienBtn = new JButton("Add");
        editNhanVienBtn = new JButton("Edit");
        deleteNhanVienBtn = new JButton("Delete");
        clearNhanVienBtn = new JButton("Clear");
        logoutBtn = new JButton("Logout");


        jScrollPaneNhanVienTable = new JScrollPane();
        NhanVienTable = new JTable();

        // khởi tạo các label
        usernameLabel = new JLabel("Username");
        NhanVienLabel = new JLabel("Password");
        ageNhanVienLabel = new JLabel("age");
        addressNhanVienLabel = new JLabel("address");
        phoneNhanVienLabel = new JLabel("phone");


        titleNhanVienLabel = new JLabel("Danh Sách Nhân Viên");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleNhanVienLabel.setFont(font);

        usernameField = new JTextField(15);
        NhanVienField = new JTextField(15);

        ageNhanVienField = new JTextField(15);
        addressNhanVienField = new JTextField(15);
        phoneNhanVienField = new JTextField(15);

        // cài đặt các cột và data cho bảng NhanVien
        NhanVienTable.setModel(new DefaultTableModel((Object[][]) data, columnNhanVien));
        jScrollPaneNhanVienTable.setViewportView(NhanVienTable);
        jScrollPaneNhanVienTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý NhanVien
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneNhanVienTable);

        panel.add(addNhanVienBtn);
        panel.add(editNhanVienBtn);
        panel.add(deleteNhanVienBtn);
        panel.add(clearNhanVienBtn);


        panel.add(logoutBtn);

        panel.add(usernameLabel);
        panel.add(NhanVienLabel);
        panel.add(addressNhanVienLabel);
        panel.add(phoneNhanVienLabel);

        panel.add(ageNhanVienLabel);

        panel.add(titleNhanVienLabel);

        panel.add(usernameField);
        panel.add(NhanVienField);
        panel.add(addressNhanVienField);

        panel.add(ageNhanVienField);
        panel.add(addressNhanVienField);
        panel.add(phoneNhanVienField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, usernameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, NhanVienLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, NhanVienLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageNhanVienLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageNhanVienLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressNhanVienLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressNhanVienLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneNhanVienLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNhanVienLabel, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleNhanVienLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleNhanVienLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, logoutBtn, 790, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, logoutBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, usernameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, NhanVienField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, NhanVienField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressNhanVienField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressNhanVienField, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageNhanVienField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageNhanVienField, 120, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, phoneNhanVienField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNhanVienField, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneNhanVienTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneNhanVienTable, 60, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addNhanVienBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addNhanVienBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editNhanVienBtn, 70, SpringLayout.WEST, addNhanVienBtn);
        layout.putConstraint(SpringLayout.NORTH, editNhanVienBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteNhanVienBtn, 70, SpringLayout.WEST, editNhanVienBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteNhanVienBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearNhanVienBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearNhanVienBtn, 75, SpringLayout.WEST, deleteNhanVienBtn);


        this.add(panel);
        this.pack();
        this.setTitle("Quản lý NhanVien");
        this.setSize(950, 380);
        // disable Edit and Delete buttons
        editNhanVienBtn.setEnabled(false);
        deleteNhanVienBtn.setEnabled(false);
        addNhanVienBtn.setEnabled(true);

        editNhanVienBtn.setEnabled(false);
        deleteNhanVienBtn.setEnabled(false);
        addNhanVienBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list NhanVien vào bảng NhanVienTable
     *
     * @param list
     */
    public void showListNhanViens(List<NhanVien> list) {
        int size = list.size();
        Object[][] NhanViens = new Object[size][5];
        for (int i = 0; i < size; i++) {
            NhanViens[i][0] = list.get(i).getUserName();
            NhanViens[i][1] = list.get(i).getPassword();
            NhanViens[i][2] = list.get(i).getAge();
            NhanViens[i][3] = list.get(i).getAddress();
            NhanViens[i][4] = list.get(i).getPhone();

        }
        NhanVienTable.setModel(new DefaultTableModel(NhanViens, columnNhanVien));
    }

    public void clearNhanVienInfo() {
        usernameField.setText("");
        NhanVienField.setText("");
        ageNhanVienField.setText("");
        addressNhanVienField.setText("");
        phoneNhanVienField.setText("");

        editNhanVienBtn.setEnabled(false);
        deleteNhanVienBtn.setEnabled(false);
        addNhanVienBtn.setEnabled(true);
    }


    public NhanVien getNhanVienInfo() {
        try {
            String password = NhanVienField.getText();
            byte age = (byte) Integer.parseInt(ageNhanVienField.getText());
            String address = addressNhanVienField.getText();
            String phone = phoneNhanVienField.getText();
            String username = usernameField.getText();
            if (username.equals("")) {
                return null;
            }
            return new NhanVien(username,password, age, address, phone);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public void fillNhanVienFromSelectedRow() {

        int row = NhanVienTable.getSelectedRow();
        if (row >= 0) {
            usernameField.setText(NhanVienTable.getModel().getValueAt(row, 0).toString());
            NhanVienField.setText(NhanVienTable.getModel().getValueAt(row, 1).toString());
            ageNhanVienField.setText(NhanVienTable.getModel().getValueAt(row, 2).toString());
            addressNhanVienField.setText(NhanVienTable.getModel().getValueAt(row, 3).toString());
            phoneNhanVienField.setText(NhanVienTable.getModel().getValueAt(row, 4).toString());

            editNhanVienBtn.setEnabled(true);
            deleteNhanVienBtn.setEnabled(true);
            addNhanVienBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddNhanVienListener(ActionListener listener) {
        addNhanVienBtn.addActionListener(listener);
    }

    public void addEditNhanVienListener(ActionListener listener) {
        editNhanVienBtn.addActionListener(listener);
    }

    public void addDeleteNhanVienListener(ActionListener listener) {
        deleteNhanVienBtn.addActionListener(listener);
    }

    public void addClearNhanVienListener(ActionListener listener) {
        clearNhanVienBtn.addActionListener(listener);
    }

    public void backNhanVienListener(ActionListener listener) {
        logoutBtn.addActionListener(listener);
    }


    public void addListNhanVienSelectionListener(ListSelectionListener listener) {
        NhanVienTable.getSelectionModel().addListSelectionListener(listener);
    }


}
