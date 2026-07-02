import java.util.*;

// category interface 
interface Category {
    String getCategoryName();
}

// classes implementing the Category interface
class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Product class with a generic type parameter extending Category
class Product<T extends Category> {
    String productName;
    double price;
    T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
}

// main class
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<BookCategory>("Java Basics", 500, new BookCategory());
        Product<ClothingCategory> clothing = new Product<ClothingCategory>("Denim Jacket", 1200, new ClothingCategory());
        Product<GadgetCategory> gadget = new Product<GadgetCategory>("Bluetooth Speaker", 2500, new GadgetCategory());

        List<Product<? extends Category>> catalog = new ArrayList<Product<? extends Category>>();
        catalog.add(book);
        catalog.add(clothing);
        catalog.add(gadget);

        applyDiscount(book, 10);
        applyDiscount(clothing, 15);
        applyDiscount(gadget, 20);

        for (Product<? extends Category> product : catalog) {
            System.out.println(product.productName + " | " + product.category.getCategoryName() + " | Rs." + product.price);
        }
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.price * percentage / 100;
        product.price = product.price - discount;
    }
}

