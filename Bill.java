package SRC;

import java.util.*;


public class Bill {
    private List<String> billSummary = new ArrayList<>();
    private double total = 0;

    public void addItem(Item item, int qty) {
        double cost = item.calculateCost(qty);
        total += cost;
        billSummary.add(item.getName() + " x " + qty + " = ₹" + String.format("%.2f", cost));
    }

    public void viewBill() {
        System.out.println("\n--- Current Bill ---");
        for (String line : billSummary) {
            System.out.println(line);
        }
        System.out.printf("Total so far: ₹%.2f\n", total);
    }

    public void checkout(String customerName, String contact) {
        System.out.println("\n--- Final Bill ---");
        System.out.printf("Customer: %s | Contact: %s\n", customerName, contact);
        for (String line : billSummary) {
            System.out.println(line);
        }
        System.out.printf("TOTAL: ₹%.2f\n", total);
        System.out.println("Thank you for shopping!");
    }
}
