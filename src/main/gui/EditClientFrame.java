package main.gui;

import javax.swing.*;
import java.awt.*;
import main.service.ClientService;

public class EditClientFrame extends JFrame {

    public EditClientFrame() {
        setTitle("Edit Profile");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        add(new JLabel("New Name:"));
        add(nameField);

        add(new JLabel("New Email:"));
        add(emailField);

        add(new JLabel("New Password:"));
        add(passwordField);

        JButton updateBtn = new JButton("Update");
        add(updateBtn);
        JButton backBtn = new JButton("Back");
        add(backBtn);
        backBtn.addActionListener(e -> {
        new ClientDashboard();
        dispose(); 
            });
        updateBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            ClientService service = new ClientService();
            service.updateClient(name, email, password);

            JOptionPane.showMessageDialog(this, "Updated Successfully!");
        });

        setVisible(true);
    }
}