package main.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import main.model.Product;
import main.model.client; 
import main.model.order; 

public class ClientService { 

    private ArrayList<client> clients = new ArrayList<>(); 
    private ArrayList<order> orders = new ArrayList<>(); 
    private ArrayList<Product> products = new ArrayList<>(); 

    private Scanner input = new Scanner(System.in); 
    private client currentClient = null; 
    private int nextOrderId = 1; 

    public ClientService() { // constructor

       
        products.add(new Product(1, "Milk", 10, 20.0, "Dairy",
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 2, 1)));

        products.add(new Product(2, "Bread", 15, 5.0, "Food",
                LocalDate.of(2024, 1, 5),
                LocalDate.of(2024, 1, 20)));
    
         products.add(new Product(3, "yogurt", 50, 15, "Dairy",
                LocalDate.of(2024, 1, 5),
                LocalDate.of(2024, 1, 20)));
    
    
            }

    // ================= REGISTER =================
    public void register() {

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        clients.add(new client(username, "test@mail.com", password));

        System.out.println("User Registered!");
    }
    // ================= REGISTER CLIENT =================
    public void registerClient(String name, String email, String password) {
    clients.add(new client(name, email, password));
    System.out.println("Client Registered!");
    }
    // ================= UPDATE CLIENT =================
    public void updateClient(String name, String email, String password) {

    if (clients.isEmpty()) {
        System.out.println("No clients found!");
        return;
    }

    client c = clients.get(0);

    c.editData(name, email, password);

    System.out.println("Client Updated!");
}

    // ================= LOGIN =================
    public void login() {

        while (true) { 

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            boolean found = false;

            for (client c : clients) {

                if (c.getName().equals(username) && c.getPassword().equals(password)) {
                    currentClient = c;
                    System.out.println("Login successful!");
                    found = true;
                    break;
                }
            }

            if (found) break;

            System.out.println("Wrong data, try again!");
        }
    }

    // ================= EDIT =================
    public void editClientData() {

        if (currentClient == null) {
            System.out.println("Login first!");
            return;
        }

        System.out.print("Enter new username: ");
        String newUser = input.nextLine();

        System.out.print("Enter new password: ");
        String newPass = input.nextLine();

        currentClient.editData(newUser, "updated@mail.com", newPass);

        System.out.println("Data updated!");
    }

   // ================= CREATE ORDER =================
public void createOrder(String productName, int qty) {

    if (currentClient == null) {
        System.out.println("Login first!");
        return;
    }

    Product selected = null;

    for (Product p : products) {
        if (p.getName().equalsIgnoreCase(productName)) {
            selected = p;
            break;
        }
    }

    if (selected == null) {
        System.out.println("Product not found!");
        return;
    }

    if (qty > selected.getQuantity()) {
        System.out.println("Not enough quantity!");
        return;
    }

    // خصم الكمية
    selected.setQuantity(selected.getQuantity() - qty);

    // إنشاء order
    order newOrder = new order(nextOrderId++, currentClient.getName(), selected, qty);

    orders.add(newOrder);

    System.out.println("Order created!");
}
}





