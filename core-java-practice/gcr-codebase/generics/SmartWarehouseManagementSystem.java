import java.util.*;

// Abstract class representing a warehouse item
abstract class WarehouseItem {
    String itemId;
    String itemName;

    public WarehouseItem(String itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public abstract String getType();
}

// Subclasses for specific types of warehouse items
class Electronics extends WarehouseItem {
    public Electronics(String itemId, String itemName) {
        super(itemId, itemName);
    }

    public String getType() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String itemId, String itemName) {
        super(itemId, itemName);
    }

    public String getType() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String itemId, String itemName) {
        super(itemId, itemName);
    }

    public String getType() {
        return "Furniture";
    }
}

// Generic Storage class to manage warehouse items
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<T>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        displayAllItems(items);
    }

    public void displayAllItems(List<? extends WarehouseItem> itemList) {
        System.out.println("Items in storage:");
        for (WarehouseItem item : itemList) {
            System.out.println(item.itemId + " - " + item.itemName + " - " + item.getType());
        }
        System.out.println();
    }
}


public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<Electronics>();
        electronicsStorage.addItem(new Electronics("E101", "Laptop"));
        electronicsStorage.addItem(new Electronics("E102", "Mobile"));

        Storage<Groceries> groceriesStorage = new Storage<Groceries>();
        groceriesStorage.addItem(new Groceries("G201", "Rice"));
        groceriesStorage.addItem(new Groceries("G202", "Sugar"));

        Storage<Furniture> furnitureStorage = new Storage<Furniture>();
        furnitureStorage.addItem(new Furniture("F301", "Chair"));
        furnitureStorage.addItem(new Furniture("F302", "Table"));

        electronicsStorage.displayItems();
        groceriesStorage.displayItems();
        furnitureStorage.displayItems();
    }
}