import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration(); // Abstract method

    public String getItemDetails() { // Concrete method
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }
}

// Interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true; // Initially available

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan duration for books
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + getItemDetails() + "' has been reserved.");
        } else {
            System.out.println("Book '" + getItemDetails() + "' is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Magazine class (Not Reservable)
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan duration for magazines
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true; // Initially available

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days loan duration for DVDs
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD '" + getItemDetails() + "' has been reserved.");
        } else {
            System.out.println("DVD '" + getItemDetails() + "' is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B101", "Java Programming", "James Gosling"));
        items.add(new Magazine("M202", "Tech Monthly", "Editorial Team"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        // Processing different library items
        for (int i = 0; i < items.size(); i++) {
            LibraryItem item = items.get(i);
            System.out.println("Item Details: " + item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Availability before reservation: " + (reservableItem.checkAvailability() ? "Available" : "Not Available"));
                reservableItem.reserveItem();
                System.out.println("Availability after reservation: " + (reservableItem.checkAvailability() ? "Available" : "Not Available"));
            }

            System.out.println("--------------------------");
        }
    }
}
