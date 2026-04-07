package main;

import main.model.Product;
import main.service.ProductService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductService service = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Inventory System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. View All Products");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // مهم لتنظيف الـ input

            //Add Product
            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine(); // علشان يدعم مسافات

                System.out.print("Enter Quantity: ");
                int quantity = scanner.nextInt();

                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter Category: ");
                String category = scanner.nextLine();

                //إدخال التواريخ من المستخدم
                System.out.print("Enter production date (YYYY-MM-DD): ");
                String prodDateStr = scanner.nextLine();

                System.out.print("Enter expiry date (YYYY-MM-DD): ");
                String expDateStr = scanner.nextLine();

                LocalDate productionDate = LocalDate.parse(prodDateStr);
                LocalDate expiryDate = LocalDate.parse(expDateStr);

                Product product = new Product(
                        id, name, quantity, price, category,
                        productionDate, expiryDate);

                service.addProduct(product);
            }

            //Delete Product
            else if (choice == 2) {

                System.out.print("Enter Product ID to delete: ");
                int id = scanner.nextInt();

                service.deleteProduct(id);
            }

            // View Products
            else if (choice == 3) {

                System.out.println(service.getAllProducts());
            }

            // Exit
            else if (choice == 4) {

                System.out.println("Program ended");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}