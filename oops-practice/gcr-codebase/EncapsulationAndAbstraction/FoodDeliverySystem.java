abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50;
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        VegItem veg = new VegItem("Paneer Pizza", 200, 2);
        NonVegItem nonVeg = new NonVegItem("Chicken Burger", 150, 2);

        veg.displayItemDetails();
        System.out.println("Total Price: " + veg.calculateTotalPrice() + "\n");

        nonVeg.displayItemDetails();
        System.out.println("Total Price: " + nonVeg.calculateTotalPrice());
    }
}