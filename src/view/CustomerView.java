package view;



import model.Customer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;


public class CustomerView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addCustomerBtn;
    private JButton editCustomerBtn;
    private JButton deleteCustomerBtn;
    private JButton clearCustomerBtn;

    private JButton logoutBtn;

    private JScrollPane jScrollPaneCustomerTable;

    private JTable CustomerTable;

    private JLabel idLabel;
    private JLabel CustomerLabel;
    private JLabel ageCustomerLabel;
    private JLabel addressCustomerLabel;
    private JLabel phoneCustomerLabel;

    private JTextField idCustomerField;
    private JTextField CustomerField;
    private JTextField ageCustomerField;
    private JTextField addressCustomerField;
    private JTextField phoneCustomerField;


    private JLabel titleCustomerLabel;


    private String[] columnCustomer = new String[]{
            "Id", "Name", "Age", "Address", "phone"};

    private Object data = new Object[][]{};

    public CustomerView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addCustomerBtn = new JButton("Add");
        editCustomerBtn = new JButton("Edit");
        deleteCustomerBtn = new JButton("Delete");
        clearCustomerBtn = new JButton("Clear");
        logoutBtn = new JButton("Logout");


        jScrollPaneCustomerTable = new JScrollPane();
        CustomerTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        CustomerLabel = new JLabel("Name");
        ageCustomerLabel = new JLabel("age");
        addressCustomerLabel = new JLabel("address");
        phoneCustomerLabel = new JLabel("phone");


        titleCustomerLabel = new JLabel("Danh Sách Customer");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleCustomerLabel.setFont(font);

        idCustomerField = new JTextField(15);
        idCustomerField.setEditable(false);
        CustomerField = new JTextField(15);

        ageCustomerField = new JTextField(15);
        addressCustomerField = new JTextField(15);
        phoneCustomerField = new JTextField(15);

        // cài đặt các cột và data cho bảng Customer
        CustomerTable.setModel(new DefaultTableModel((Object[][]) data, columnCustomer));
        jScrollPaneCustomerTable.setViewportView(CustomerTable);
        jScrollPaneCustomerTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Customer
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneCustomerTable);

        panel.add(addCustomerBtn);
        panel.add(editCustomerBtn);
        panel.add(deleteCustomerBtn);
        panel.add(clearCustomerBtn);


        panel.add(logoutBtn);

        panel.add(idLabel);
        panel.add(CustomerLabel);
        panel.add(addressCustomerLabel);
        panel.add(phoneCustomerLabel);

        panel.add(ageCustomerLabel);

        panel.add(titleCustomerLabel);

        panel.add(idCustomerField);
        panel.add(CustomerField);
        panel.add(addressCustomerField);

        panel.add(ageCustomerField);
        panel.add(addressCustomerField);
        panel.add(phoneCustomerField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, CustomerLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, CustomerLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageCustomerLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageCustomerLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressCustomerLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressCustomerLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneCustomerLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneCustomerLabel, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleCustomerLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleCustomerLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, logoutBtn, 790, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, logoutBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idCustomerField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idCustomerField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, CustomerField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, CustomerField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressCustomerField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressCustomerField, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageCustomerField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageCustomerField, 120, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, phoneCustomerField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneCustomerField, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneCustomerTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneCustomerTable, 60, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addCustomerBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addCustomerBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editCustomerBtn, 70, SpringLayout.WEST, addCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, editCustomerBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteCustomerBtn, 70, SpringLayout.WEST, editCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteCustomerBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearCustomerBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearCustomerBtn, 75, SpringLayout.WEST, deleteCustomerBtn);


        this.add(panel);
        this.pack();
        this.setTitle("Quản lý Customer");
        this.setSize(950, 380);
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        addCustomerBtn.setEnabled(true);

        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        addCustomerBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list Customer vào bảng CustomerTable
     *
     * @param list
     */
    public void showListCustomers(List<Customer> list) {
        int size = list.size();
        Object[][] Customers = new Object[size][5];
        for (int i = 0; i < size; i++) {
            Customers[i][0] = list.get(i).getId();
            Customers[i][1] = list.get(i).getName();
            Customers[i][2] = list.get(i).getAge();
            Customers[i][3] = list.get(i).getAddress();
            Customers[i][4] = list.get(i).getPhone();

        }
        CustomerTable.setModel(new DefaultTableModel(Customers, columnCustomer));
    }

    public void clearCustomerInfo() {
        idCustomerField.setText("");
        CustomerField.setText("");
        ageCustomerField.setText("");
        addressCustomerField.setText("");
        phoneCustomerField.setText("");

        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        addCustomerBtn.setEnabled(true);
    }


    public Customer getCustomerInfo() {
        try {
            String name = CustomerField.getText();
            byte age = (byte) Integer.parseInt(ageCustomerField.getText());
            String address = addressCustomerField.getText();
            String phone = phoneCustomerField.getText();
            String id = idCustomerField.getText();
            if (id.equals("")) {
                return new Customer(name, age, address, phone);
            }
            int idP = Integer.parseInt(id);
            return new Customer(idP,name, age, address, phone);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public void fillCustomerFromSelectedRow() {

        int row = CustomerTable.getSelectedRow();
        if (row >= 0) {
            idCustomerField.setText(CustomerTable.getModel().getValueAt(row, 0).toString());
            CustomerField.setText(CustomerTable.getModel().getValueAt(row, 1).toString());
            ageCustomerField.setText(CustomerTable.getModel().getValueAt(row, 2).toString());
            addressCustomerField.setText(CustomerTable.getModel().getValueAt(row, 3).toString());
            phoneCustomerField.setText(CustomerTable.getModel().getValueAt(row, 4).toString());

            editCustomerBtn.setEnabled(true);
            deleteCustomerBtn.setEnabled(true);
            addCustomerBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddCustomerListener(ActionListener listener) {
        addCustomerBtn.addActionListener(listener);
    }

    public void addEditCustomerListener(ActionListener listener) {
        editCustomerBtn.addActionListener(listener);
    }

    public void addDeleteCustomerListener(ActionListener listener) {
        deleteCustomerBtn.addActionListener(listener);
    }

    public void addClearCustomerListener(ActionListener listener) {
        clearCustomerBtn.addActionListener(listener);
    }

    public void backCustomerListener(ActionListener listener) {
        logoutBtn.addActionListener(listener);
    }


    public void addListCustomerSelectionListener(ListSelectionListener listener) {
        CustomerTable.getSelectionModel().addListSelectionListener(listener);
    }


}
