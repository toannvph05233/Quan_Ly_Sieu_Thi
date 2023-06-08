package view;


import model.NhaCungCap;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;


public class NhaCungCapView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addNhaCungCapBtn;
    private JButton editNhaCungCapBtn;
    private JButton deleteNhaCungCapBtn;
    private JButton clearNhaCungCapBtn;

    private JButton logoutBtn;

    private JScrollPane jScrollPaneNhaCungCapTable;

    private JTable NhaCungCapTable;

    private JLabel idNCCLabel;
    private JLabel NhaCungCapLabel;
    private JLabel addressNhaCungCapLabel;
    private JLabel phoneNhaCungCapLabel;

    private JTextField idNCCField;
    private JTextField NhaCungCapField;
    private JTextField addressNhaCungCapField;
    private JTextField phoneNhaCungCapField;


    private JLabel titleNhaCungCapLabel;


    private String[] columnNhaCungCap = new String[]{
            "Username", "Password", "Age", "Address", "phone"};

    private Object data = new Object[][]{};

    public NhaCungCapView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addNhaCungCapBtn = new JButton("Add");
        editNhaCungCapBtn = new JButton("Edit");
        deleteNhaCungCapBtn = new JButton("Delete");
        clearNhaCungCapBtn = new JButton("Clear");
        logoutBtn = new JButton("Back");


        jScrollPaneNhaCungCapTable = new JScrollPane();
        NhaCungCapTable = new JTable();

        // khởi tạo các label
        idNCCLabel = new JLabel("idNCC");
        NhaCungCapLabel = new JLabel("nameNCC");
        addressNhaCungCapLabel = new JLabel("address");
        phoneNhaCungCapLabel = new JLabel("phone");


        titleNhaCungCapLabel = new JLabel("Danh Sách Nhà Cung Cấp");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleNhaCungCapLabel.setFont(font);

        idNCCField = new JTextField(15);
        NhaCungCapField = new JTextField(15);

        addressNhaCungCapField = new JTextField(15);
        phoneNhaCungCapField = new JTextField(15);

        // cài đặt các cột và data cho bảng NhaCungCap
        NhaCungCapTable.setModel(new DefaultTableModel((Object[][]) data, columnNhaCungCap));
        jScrollPaneNhaCungCapTable.setViewportView(NhaCungCapTable);
        jScrollPaneNhaCungCapTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý NhaCungCap
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneNhaCungCapTable);

        panel.add(addNhaCungCapBtn);
        panel.add(editNhaCungCapBtn);
        panel.add(deleteNhaCungCapBtn);
        panel.add(clearNhaCungCapBtn);


        panel.add(logoutBtn);

        panel.add(idNCCLabel);
        panel.add(NhaCungCapLabel);
        panel.add(addressNhaCungCapLabel);
        panel.add(phoneNhaCungCapLabel);

        panel.add(titleNhaCungCapLabel);

        panel.add(idNCCField);
        panel.add(NhaCungCapField);
        panel.add(addressNhaCungCapField);

        panel.add(addressNhaCungCapField);
        panel.add(phoneNhaCungCapField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idNCCLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idNCCLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, NhaCungCapLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, NhaCungCapLabel, 90, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, ageNhaCungCapLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, ageNhaCungCapLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressNhaCungCapLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressNhaCungCapLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneNhaCungCapLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNhaCungCapLabel, 150, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleNhaCungCapLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleNhaCungCapLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, logoutBtn, 790, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, logoutBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idNCCField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idNCCField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, NhaCungCapField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, NhaCungCapField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressNhaCungCapField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressNhaCungCapField, 120, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, ageNhaCungCapField, 100, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, ageNhaCungCapField, 120, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, phoneNhaCungCapField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNhaCungCapField, 150, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneNhaCungCapTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneNhaCungCapTable, 60, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addNhaCungCapBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addNhaCungCapBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editNhaCungCapBtn, 70, SpringLayout.WEST, addNhaCungCapBtn);
        layout.putConstraint(SpringLayout.NORTH, editNhaCungCapBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteNhaCungCapBtn, 70, SpringLayout.WEST, editNhaCungCapBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteNhaCungCapBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearNhaCungCapBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearNhaCungCapBtn, 75, SpringLayout.WEST, deleteNhaCungCapBtn);


        this.add(panel);
        this.pack();
        this.setTitle("Quản lý NhaCungCap");
        this.setSize(950, 380);
        // disable Edit and Delete buttons
        editNhaCungCapBtn.setEnabled(false);
        deleteNhaCungCapBtn.setEnabled(false);
        addNhaCungCapBtn.setEnabled(true);

        editNhaCungCapBtn.setEnabled(false);
        deleteNhaCungCapBtn.setEnabled(false);
        addNhaCungCapBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list NhaCungCap vào bảng NhaCungCapTable
     *
     * @param list
     */
    public void showListNhaCungCaps(List<NhaCungCap> list) {
        int size = list.size();
        Object[][] NhaCungCaps = new Object[size][5];
        for (int i = 0; i < size; i++) {
            NhaCungCaps[i][0] = list.get(i).getId();
            NhaCungCaps[i][1] = list.get(i).getName();
            NhaCungCaps[i][3] = list.get(i).getAddress();
            NhaCungCaps[i][4] = list.get(i).getPhone();

        }
        NhaCungCapTable.setModel(new DefaultTableModel(NhaCungCaps, columnNhaCungCap));
    }

    public void clearNhaCungCapInfo() {
        idNCCField.setText("");
        NhaCungCapField.setText("");
        addressNhaCungCapField.setText("");
        phoneNhaCungCapField.setText("");

        editNhaCungCapBtn.setEnabled(false);
        deleteNhaCungCapBtn.setEnabled(false);
        addNhaCungCapBtn.setEnabled(true);
    }


    public NhaCungCap getNhaCungCapInfo() {
        try {
            String password = NhaCungCapField.getText();
            String address = addressNhaCungCapField.getText();
            String phone = phoneNhaCungCapField.getText();
            int id = Integer.parseInt(idNCCField.getText());
            return new NhaCungCap(id, password, address, phone, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public void fillNhaCungCapFromSelectedRow() {

        int row = NhaCungCapTable.getSelectedRow();
        if (row >= 0) {
            idNCCField.setText(NhaCungCapTable.getModel().getValueAt(row, 0).toString());
            NhaCungCapField.setText(NhaCungCapTable.getModel().getValueAt(row, 1).toString());
            addressNhaCungCapField.setText(NhaCungCapTable.getModel().getValueAt(row, 3).toString());
            phoneNhaCungCapField.setText(NhaCungCapTable.getModel().getValueAt(row, 4).toString());

            editNhaCungCapBtn.setEnabled(true);
            deleteNhaCungCapBtn.setEnabled(true);
            addNhaCungCapBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddNhaCungCapListener(ActionListener listener) {
        addNhaCungCapBtn.addActionListener(listener);
        clearNhaCungCapInfo();

    }

    public void addEditNhaCungCapListener(ActionListener listener) {
        editNhaCungCapBtn.addActionListener(listener);
        clearNhaCungCapInfo();

    }

    public void addDeleteNhaCungCapListener(ActionListener listener) {
        deleteNhaCungCapBtn.addActionListener(listener);
        clearNhaCungCapInfo();
    }

    public void addClearNhaCungCapListener(ActionListener listener) {
        clearNhaCungCapBtn.addActionListener(listener);
    }

    public void backNhaCungCapListener(ActionListener listener) {
        logoutBtn.addActionListener(listener);
    }


    public void addListNhaCungCapSelectionListener(ListSelectionListener listener) {
        NhaCungCapTable.getSelectionModel().addListSelectionListener(listener);
    }


}
