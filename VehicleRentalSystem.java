import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public double getRentalRate() {
        return rentalRate;
    }

    public String getType() {
        return type;
    }
}

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Concrete Class - Car
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance @5% of rental rate";
    }
}

// Concrete Class - Bike
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Concrete Class - Truck
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // 20% extra charge for trucks
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance @10% of rental rate";
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car("CAR123", 1500));
        vehicleList.add(new Bike("BIKE456", 500));
        vehicleList.add(new Truck("TRUCK789", 3000));

        int rentalDays = 5; // Example rental duration

        // Using normal for-loop
        for (int i = 0; i < vehicleList.size(); i++) {
            Vehicle v = vehicleList.get(i);
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = (v instanceof Insurable) ? ((Insurable) v).calculateInsurance() : 0;

            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            if (v instanceof Insurable) {
                System.out.println("Insurance Cost: " + insuranceCost);
                System.out.println("Insurance Details: " + ((Insurable) v).getInsuranceDetails());
            }
            System.out.println("-----------------------------");
        }
    }
}
