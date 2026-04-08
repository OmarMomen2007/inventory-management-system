package main.gui;

import java.awt.*;
import javax.swing.*;

import main.service.ClientService;

public class ClientFrame extends JFrame {

    public ClientFrame() {
        setTitle("Register Client");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        add(passwordField);

        JButton registerBtn = new JButton("Register");
        add(registerBtn);
        JButton backBtn = new JButton("Back");
        add(backBtn);
        backBtn.addActionListener(e -> {
            new ClientDashboard();
            dispose(); 
        });
        registerBtn.addActionListener(e -> {
    String name = nameField.getText();
    String email = emailField.getText();
    String password = new String(passwordField.getPassword());

    ClientService service = new ClientService();
    service.registerClient(name, email, password);

    JOptionPane.showMessageDialog(this, "Registered Successfully!");
});

        setVisible(true);
    }
}