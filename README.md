# Supermarket Billing System (Java Console)

This project is a "console-based Supermarket Billing System" written in Java.  
It simulates a simple billing counter where a customer’s details are taken, items are added using barcodes and quantities, and a final bill is generated with discount and tax applied.


✅Features

- Menu-driven console interface
- Takes customer name and 10-digit contact number (with validation)
- Predefined grocery items stored with:
  - Barcode (e.g., 1001, 1002, 1003…)
  - Name and base price
  - Discount percentage
  - Tax percentage (GST)
- Add items to the bill using barcode and quantity
- Automatic calculation of:
  - Discounted price
  - Tax on discounted price
  - Final cost for the given quantity
- View current bill at any time
- Checkout to print final bill and total amount
- Clean and simple code, suitable for beginners and college projects


✅Technologies Used

- Language: Java  
- Core Concepts:
  - Classes and Objects
  - Abstract Class (`Item`)
  - Inheritance (`RegularItem` extends `Item`)
  - Collections:
    - `HashMap` for inventory (barcode → item)
    - `ArrayList` for bill summary
  - Loops and `switch` for menu-driven flow
  - Basic input validation using regex for contact number (`\\d{10}`)


✅Project Structure

```text
SRC/
├── Item.java          # Abstract base class: fields + cost calculation
├── RegularItem.java   # Child class for regular grocery items
├── Bill.java          # Manages bill lines and total
└── BillingSystem.java # Main class with menu and user interaction
