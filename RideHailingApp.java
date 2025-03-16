abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    abstract void calculateFare(double distance);

    void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: ₹" + ratePerKm);
    }
}

interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private static final double RATE_PER_KM = 12.0;

    Car(int vehicleId, String driverName) {
        super(vehicleId, driverName, RATE_PER_KM);
    }

    @Override
    void calculateFare(double distance) {
        double fare = distance * RATE_PER_KM;
        System.out.println("Car Fare for " + distance + " km: ₹" + fare);
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Car Location: Sector 10");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Car moved to: " + newLocation);
    }
}

class Bike extends Vehicle implements GPS {
    private static final double RATE_PER_KM = 7.0;

    Bike(int vehicleId, String driverName) {
        super(vehicleId, driverName, RATE_PER_KM);
    }

    @Override
    void calculateFare(double distance) {
        double fare = distance * RATE_PER_KM;
        System.out.println("Bike Fare for " + distance + " km: ₹" + fare);
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Bike Location: Main Road");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Bike moved to: " + newLocation);
    }
}

class Auto extends Vehicle implements GPS {
    private static final double RATE_PER_KM = 9.0;

    Auto(int vehicleId, String driverName) {
        super(vehicleId, driverName, RATE_PER_KM);
    }

    @Override
    void calculateFare(double distance) {
        double fare = distance * RATE_PER_KM;
        System.out.println("Auto Fare for " + distance + " km: ₹" + fare);
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Auto Location: Bus Stand");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Auto moved to: " + newLocation);
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle v1 = new Car(101, "Amit Sharma");
        v1.getVehicleDetails();
        v1.calculateFare(10); // 10 km ride

        GPS gps1 = (GPS) v1;
        gps1.getCurrentLocation();
        gps1.updateLocation("Sector 15");

        Vehicle v2 = new Bike(102, "Rahul Verma");
        v2.getVehicleDetails();
        v2.calculateFare(5); // 5 km ride

        GPS gps2 = (GPS) v2;
        gps2.getCurrentLocation();
        gps2.updateLocation("Mall Road");

        Vehicle v3 = new Auto(103, "Suresh Kumar");
        v3.getVehicleDetails();
        v3.calculateFare(7); // 7 km ride

        GPS gps3 = (GPS) v3;
        gps3.getCurrentLocation();
        gps3.updateLocation("Railway Station");
    }
}
