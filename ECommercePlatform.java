import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Concrete Class - Electronics
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST @18%";
    }
}

// Concrete Class - Clothing
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST @5%";
    }
}

// Concrete Class - Groceries (No Tax)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Electronics(101, "Laptop", 50000));
        productList.add(new Clothing(102, "T-Shirt", 1000));
        productList.add(new Groceries(103, "Rice Bag", 2000));


        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = p.getPrice() - discount + tax;

            System.out.println("Product: " + p.getName());
            System.out.println("Original Price: " + p.getPrice());
            System.out.println("Discount: -" + discount);
            System.out.println("Tax: +" + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------");
        }
    }
}
