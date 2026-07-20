abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    abstract int getLoanDuration();
}

class Book extends LibraryItem {
    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Book b = new Book(101, "Java Programming", "James");
        Magazine m = new Magazine(201, "Tech Today", "Alex");
        DVD d = new DVD(301, "Avengers", "Marvel");

        b.displayItemDetails();
        System.out.println("Loan Duration: " + b.getLoanDuration() + " days\n");

        m.displayItemDetails();
        System.out.println("Loan Duration: " + m.getLoanDuration() + " days\n");

        d.displayItemDetails();
        System.out.println("Loan Duration: " + d.getLoanDuration() + " days");
    }
}