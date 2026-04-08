package main.gui;

import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Login");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50,50,100,30);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150,50,150,30);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50,100,100,30);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150,100,150,30);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150,160,100,30);
        add(loginBtn);

        //  Action
        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            String role = RoleSelectionFrame.selectedRole;

            //  Admin Login
            if(role.equals("ADMIN") && user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Welcome Admin");
                new AdminDashboard();
                dispose();
            }
            //  Client Login
            else if(role.equals("CLIENT") && user.equals("client") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Welcome Client");
                new ClientDashboard();
                dispose();
            }
            //  Wrong بيانات
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        });

        setVisible(true);
    }
}