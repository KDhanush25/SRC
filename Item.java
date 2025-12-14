package SRC;

public abstract class Item {
    protected String name;
    protected double price;
    protected double discount;
    protected double tax;

    public Item(String name, double price, double discount, double tax) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
    }

    public double calculateCost(int quantity) {
        double discountAmount = price * (discount / 100);
        double priceAfterDiscount = price - discountAmount;
        double taxAmount = priceAfterDiscount * (tax / 100);
        double finalPrice = priceAfterDiscount + taxAmount;
        return finalPrice * quantity;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.printf("Item: %s | Price: ₹%.2f | Discount: %.2f%% | Tax: %.2f%%\n",
                name, price, discount, tax);
    }
}
