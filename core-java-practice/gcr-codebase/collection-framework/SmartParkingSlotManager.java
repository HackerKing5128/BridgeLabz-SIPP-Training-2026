import java.util.ArrayList;

public class SmartParkingSlotManager {
    private ArrayList<String> parkedVehicles;

    public SmartParkingSlotManager() {
        parkedVehicles = new ArrayList<String>();
    }

    public void vehicleEnter(String registrationNumber) {
        if (!parkedVehicles.contains(registrationNumber)) {
            parkedVehicles.add(registrationNumber);
            System.out.println(registrationNumber + " entered the parking area");
        } else {
            System.out.println(registrationNumber + " is already parked");
        }
    }

    public void vehicleExit(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber)) {
            System.out.println(registrationNumber + " exited the parking area");
        } else {
            System.out.println(registrationNumber + " not found in parking");
        }
    }

    public void searchVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println(registrationNumber + " is currently parked");
        } else {
            System.out.println(registrationNumber + " is not parked");
        }
    }

    public void displayParkedVehicles() {
        System.out.println("Parked Vehicles:");
        for (String vehicle : parkedVehicles) {
            System.out.println(vehicle);
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parking = new SmartParkingSlotManager();

        parking.vehicleEnter("KA01AB1234");
        parking.vehicleEnter("KA02CD2345");
        parking.vehicleEnter("KA03EF3456");
        System.out.println();
        parking.displayParkedVehicles();
        System.out.println();
        parking.vehicleExit("KA02CD2345");
        parking.searchVehicle("KA03EF3456");
        System.out.println();
        parking.displayParkedVehicles();
    }
}
