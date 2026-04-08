package main.gui;

import javax.swing.*;
import java.awt.*;
import main.service.ClientService;

public class CreateOrderFrame extends JFrame {

    public CreateOrderFrame() {

        setTitle("Create Order");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        JTextField productField = new JTextField();
        JTextField quantityField = new JTextField();

        add(new JLabel("Product Name:"));
        add(productField);

        add(new JLabel("Quantity:"));
        add(quantityField);

        JButton createBtn = new JButton("Create Order");
        add(createBtn);
        JButton backBtn = new JButton("Back");
        add(backBtn);

        backBtn.addActionListener(e -> {
            new ClientDashboard();
             dispose();
            });
        createBtn.addActionListener(e -> {
            String product = productField.getText();
            int qty = Integer.parseInt(quantityField.getText());

            ClientService service = new ClientService();
            service.createOrder(product, qty);

            JOptionPane.showMessageDialog(this, "Order Created!");
        });

        setVisible(true);
    }
}