// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice(); // Abstract method

    public String getItemDetails() { // Concrete method
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }
}

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charges for Veg Items
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item.";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_SURCHARGE = 50.0; // Extra charge for Non-Veg

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_SURCHARGE; // Extra charge applied
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item.";
    }
}

// Main Class
public class OnlineFoodDelivery {
    public static void main(String[] args) {
        // Creating objects
        FoodItem vegItem = new VegItem("Paneer Tikka", 200, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 300, 1);

        // Processing order for Veg Item
        System.out.println("Item Details: " + vegItem.getItemDetails());
        System.out.println("Total Price Before Discount: " + vegItem.calculateTotalPrice());
        Discountable d1 = (Discountable) vegItem;
        System.out.println(d1.getDiscountDetails());
        System.out.println("Final Price After Discount: " + (vegItem.calculateTotalPrice() - d1.applyDiscount()));
        System.out.println("--------------------------");

        // Processing order for Non-Veg Item
        System.out.println("Item Details: " + nonVegItem.getItemDetails());
        System.out.println("Total Price Before Discount: " + nonVegItem.calculateTotalPrice());
        Discountable d2 = (Discountable) nonVegItem;
        System.out.println(d2.getDiscountDetails());
        System.out.println("Final Price After Discount: " + (nonVegItem.calculateTotalPrice() - d2.applyDiscount()));
    }
}
