package main.gui;

import javax.swing.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(500,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton productBtn = new JButton("Manage Products");
        productBtn.setBounds(150,50,200,40);
        add(productBtn);

        JButton orderBtn = new JButton("Orders");
        orderBtn.setBounds(150,120,200,40);
        add(orderBtn);

        JButton reportBtn = new JButton("Reports");
        reportBtn.setBounds(150,190,200,40);
        add(reportBtn);

        productBtn.addActionListener(e -> new ProductFrame());

        setVisible(true);
    }
}