// Superclass Vehicle
abstract class Vehicle {
    String vehicleNumber;
    String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public abstract double calculateToll();
}

// Subclass Car
class Car extends Vehicle {
    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    public double calculateToll() {
        return 50;
    }
}

// Subclass Bus
class Bus extends Vehicle {
    public Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    public double calculateToll() {
        return 120;
    }
}

// Subclass Truck
class Truck extends Vehicle {
    public Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    public double calculateToll() {
        return 180;
    }
}

// Main class
public class SmartVehicleTollManagementSystem {
    public static void calculateTotalRevenue(Vehicle[] vehicles) {
        double totalRevenue = 0;
        for (int i = 0; i < vehicles.length; i++) {
            totalRevenue = totalRevenue + vehicles[i].calculateToll();
        }
        System.out.println("Total toll revenue: Rs." + totalRevenue);
    }

    public static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].vehicleNumber.equalsIgnoreCase(vehicleNumber)) {
                System.out.println("Vehicle found: " + vehicles[i].vehicleNumber + " owned by " + vehicles[i].ownerName);
                System.out.println("Toll paid: Rs." + vehicles[i].calculateToll());
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

    public static void displayHighestToll(Vehicle[] vehicles) {
        Vehicle highestTollVehicle = vehicles[0];
        for (int i = 1; i < vehicles.length; i++) {
            if (vehicles[i].calculateToll() > highestTollVehicle.calculateToll()) {
                highestTollVehicle = vehicles[i];
            }
        }
        System.out.println("Highest toll paid by: " + highestTollVehicle.vehicleNumber + " - Rs." + highestTollVehicle.calculateToll());
    }

    public static void countVehiclesByType(Vehicle[] vehicles) {
        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Car) {
                carCount++;
            } else if (vehicles[i] instanceof Bus) {
                busCount++;
            } else if (vehicles[i] instanceof Truck) {
                truckCount++;
            }
        }

        System.out.println("Car count: " + carCount);
        System.out.println("Bus count: " + busCount);
        System.out.println("Truck count: " + truckCount);
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("KA01AB1234", "Ravi"),
            new Bus("KA02CD2345", "Suresh"),
            new Truck("KA03EF3456", "Mohan"),
            new Car("KA04GH4567", "Anita"),
            new Truck("KA05IJ5678", "Kumar")
        };

        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].vehicleNumber + " toll: Rs." + vehicles[i].calculateToll());
        }

        calculateTotalRevenue(vehicles);
        searchVehicle(vehicles, "KA03EF3456");
        displayHighestToll(vehicles);
        countVehiclesByType(vehicles);
    }
}

