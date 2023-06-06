package view;


import model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;


public class ProductView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addProductBtn;
    private JButton editProductBtn;
    private JButton deleteProductBtn;
    private JButton clearProductBtn;
    private JButton managerCustomerBtn;

    private JButton logoutBtn;

    private JScrollPane jScrollPaneProductTable;

    private JTable ProductTable;

    private JLabel idLabel;
    private JLabel ProductLabel;
    private JLabel PriceProductLabel;
    private JLabel QuantityProductLabel;
    private JLabel dateProductLabel;
    private JLabel imgProductLabel;

    private JTextField idProductField;
    private JTextField ProductField;
    private JTextField PriceProductField;
    private JTextField QuantityProductField;
    private JTextField dateProductField;
    private JTextField imgProductField;


    private JLabel titleProductLabel;


    private String[] columnProduct = new String[]{
            "Id", "Name", "Price", "Image", "Quantity", "Date"};

    private Object data = new Object[][]{};

    public ProductView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addProductBtn = new JButton("Add");
        editProductBtn = new JButton("Edit");
        deleteProductBtn = new JButton("Delete");
        clearProductBtn = new JButton("Clear");
        managerCustomerBtn = new JButton("Manager Customer");
        logoutBtn = new JButton("Logout");


        jScrollPaneProductTable = new JScrollPane();
        ProductTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        ProductLabel = new JLabel("Name");
        PriceProductLabel = new JLabel("Price");
        QuantityProductLabel = new JLabel("Quantity");
        dateProductLabel = new JLabel("DateProduct");
        imgProductLabel = new JLabel("Image");


        titleProductLabel = new JLabel("Danh Sách Product");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleProductLabel.setFont(font);

        idProductField = new JTextField(15);
        idProductField.setEditable(false);
        ProductField = new JTextField(15);

        PriceProductField = new JTextField(15);
        QuantityProductField = new JTextField(15);
        dateProductField = new JTextField(15);
        imgProductField = new JTextField(15);

        // cài đặt các cột và data cho bảng Product
        ProductTable.setModel(new DefaultTableModel((Object[][]) data, columnProduct));
        jScrollPaneProductTable.setViewportView(ProductTable);
        jScrollPaneProductTable.setPreferredSize(new Dimension(550, 450));

        ProductTable.setRowHeight(100); // Đặt độ cao của dòng thành 100 pixel

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Product
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneProductTable);

        panel.add(addProductBtn);
        panel.add(editProductBtn);
        panel.add(deleteProductBtn);
        panel.add(clearProductBtn);
        panel.add(managerCustomerBtn);


        panel.add(logoutBtn);

        panel.add(idLabel);
        panel.add(ProductLabel);
        panel.add(QuantityProductLabel);
        panel.add(dateProductLabel);

        panel.add(PriceProductLabel);

        panel.add(titleProductLabel);

        panel.add(idProductField);
        panel.add(ProductField);
        panel.add(QuantityProductField);

        panel.add(PriceProductField);
        panel.add(QuantityProductField);
        panel.add(dateProductField);
        panel.add(imgProductField);
        panel.add(imgProductLabel);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ProductLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, PriceProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, PriceProductLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, QuantityProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, QuantityProductLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dateProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateProductLabel, 180, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imgProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, imgProductLabel, 210, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleProductLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, logoutBtn, 790, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, logoutBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idProductField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ProductField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, QuantityProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, QuantityProductField, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, PriceProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, PriceProductField, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dateProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dateProductField, 180, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, imgProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, imgProductField, 210, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneProductTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneProductTable, 60, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addProductBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addProductBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editProductBtn, 70, SpringLayout.WEST, addProductBtn);
        layout.putConstraint(SpringLayout.NORTH, editProductBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteProductBtn, 70, SpringLayout.WEST, editProductBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteProductBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearProductBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearProductBtn, 75, SpringLayout.WEST, deleteProductBtn);

        layout.putConstraint(SpringLayout.WEST, managerCustomerBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, managerCustomerBtn, 310, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Quản lý Product");
        this.setSize(950, 580);
        // disable Edit and Delete buttons
        editProductBtn.setEnabled(false);
        deleteProductBtn.setEnabled(false);
        addProductBtn.setEnabled(true);

        editProductBtn.setEnabled(false);
        deleteProductBtn.setEnabled(false);
        addProductBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list Product vào bảng ProductTable
     *
     * @param list
     */
    public void showListProducts(List<Product> list) {
        int size = list.size();
        Object[][] Products = new Object[size][6];
        for (int i = 0; i < size; i++) {
            Products[i][0] = list.get(i).getId();
            Products[i][1] = list.get(i).getName();
            Products[i][2] = list.get(i).getPrice();
            Products[i][3] = list.get(i).getImg();
            Products[i][4] = list.get(i).getCount();
            Products[i][5] = formatter.format(list.get(i).getDate());

        }
        ProductTable.setModel(new DefaultTableModel(Products, columnProduct));
        ProductTable.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

    }

    public void clearProductInfo() {
        idProductField.setText("");
        ProductField.setText("");
        PriceProductField.setText("");
        QuantityProductField.setText("");
        dateProductField.setText("");
        imgProductField.setText("");

        editProductBtn.setEnabled(false);
        deleteProductBtn.setEnabled(false);
        addProductBtn.setEnabled(true);
    }


    public Product getProductInfo() {
        try {
            String name = ProductField.getText();
            double price = Double.parseDouble(PriceProductField.getText());
            int quantity = Integer.parseInt(QuantityProductField.getText());
            String date = dateProductField.getText();
            String id = idProductField.getText();
            String img = imgProductField.getText();

            if (id.equals("")) {
                return new Product(name, price, quantity, img, formatter.parse(date));
            }
            int idP = Integer.parseInt(id);
            return new Product(idP, name, price, quantity, img, formatter.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public void fillProductFromSelectedRow() {

        int row = ProductTable.getSelectedRow();
        if (row >= 0) {
            idProductField.setText(ProductTable.getModel().getValueAt(row, 0).toString());
            ProductField.setText(ProductTable.getModel().getValueAt(row, 1).toString());
            PriceProductField.setText(ProductTable.getModel().getValueAt(row, 2).toString());
            QuantityProductField.setText(ProductTable.getModel().getValueAt(row, 4).toString());
            dateProductField.setText(ProductTable.getModel().getValueAt(row, 5).toString());
            imgProductField.setText(ProductTable.getModel().getValueAt(row, 3).toString());

            editProductBtn.setEnabled(true);
            deleteProductBtn.setEnabled(true);
            addProductBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddProductListener(ActionListener listener) {
        addProductBtn.addActionListener(listener);
        clearProductInfo();
    }

    public void addEditProductListener(ActionListener listener) {
        editProductBtn.addActionListener(listener);
        clearProductInfo();

    }

    public void addDeleteProductListener(ActionListener listener) {
        deleteProductBtn.addActionListener(listener);
        clearProductInfo();
    }

    public void addClearProductListener(ActionListener listener) {
        clearProductBtn.addActionListener(listener);
    }

    public void addManagerCustomerListener(ActionListener listener) {
        managerCustomerBtn.addActionListener(listener);
    }

    public void backProductListener(ActionListener listener) {
        logoutBtn.addActionListener(listener);
    }


    public void addListProductSelectionListener(ListSelectionListener listener) {
        ProductTable.getSelectionModel().addListSelectionListener(listener);
    }

    private static class ImageRenderer extends DefaultTableCellRenderer {
        private static final int IMAGE_WIDTH = 100;
        private static final int IMAGE_HEIGHT = 100;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            if (value != null) {
                String imagePath = (String) value;
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage();
                Image resizedImage = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(resizedImage));
            } else {
                setIcon(null);
            }

            return this;
        }
    }
}
