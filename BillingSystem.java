package SRC;

import java.util.*;

// Main class (CO1: menu-driven logic, CO3: string validation)
public class BillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Customer details
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter contact number (10 digits): ");
        String contact = sc.nextLine();
        while (!contact.matches("\\d{10}")) {
            System.out.print("Invalid! Enter 10-digit number: ");
            contact = sc.nextLine();
        }

        // Inventory setup (CO2: arrays + collections)
        Map<String, Item> inventory = new HashMap<>();
        inventory.put("1001", new RegularItem("Milk", 40, 5, 18));
        inventory.put("1002", new RegularItem("Bread", 30, 0, 18));
        inventory.put("1003", new RegularItem("Eggs", 60, 10, 5));
        inventory.put("1004", new RegularItem("Butter", 90, 8, 12));
        inventory.put("1005", new RegularItem("Cheese", 120, 7, 12));

        Bill bill = new Bill();
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. View Items");
            System.out.println("2. Add Item to Bill");
            System.out.println("3. View Current Bill");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Items:");
                    for (String code : inventory.keySet()) {
                        System.out.print("Barcode: " + code + " → ");
                        inventory.get(code).displayDetails();
                    }
                    break;

                case 2:
                    System.out.print("Enter barcode: ");
                    String code = sc.nextLine();
                    if (!inventory.containsKey(code)) {
                        System.out.println("Invalid barcode.");
                        break;
                    }
                    Item item = inventory.get(code);
                    item.displayDetails();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    bill.addItem(item, qty);
                    System.out.println("Item added to bill.");
                    break;

                case 3:
                    bill.viewBill();
                    break;

                case 4:
                    bill.checkout(customerName, contact);
                    running = false;
                    break;

                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
