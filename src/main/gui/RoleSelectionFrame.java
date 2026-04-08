package main.gui;
import java.awt.*;
import javax.swing.*;

public class RoleSelectionFrame extends JFrame {

    public static String selectedRole = "";

    public RoleSelectionFrame() {
        setTitle("Select Role");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Choose Your Role", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // Buttons Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton adminBtn = new JButton("Admin");
        JButton clientBtn = new JButton("Client");

        panel.add(adminBtn);
        panel.add(clientBtn);

        add(panel, BorderLayout.CENTER);

        // Admin Button Action
        adminBtn.addActionListener(e -> {
            selectedRole = "ADMIN";
            new LoginFrame(); 
            dispose();
        });

        // Client Button Action
        clientBtn.addActionListener(e -> {
            selectedRole = "CLIENT";
            new ClientDashboard();
            dispose();
        });

        setVisible(true);
    }
}