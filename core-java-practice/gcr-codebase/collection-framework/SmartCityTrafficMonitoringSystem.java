import java.util.*;

public class SmartCityTrafficMonitoringSystem {
    private HashMap<String, Integer> roadTraffic;

    public SmartCityTrafficMonitoringSystem() {
        roadTraffic = new HashMap<String, Integer>();
    }

    public void addOrUpdateRoad(String roadName, int vehicleCount) {
        roadTraffic.put(roadName, vehicleCount);
    }

    public void displaySortedRoads() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<String, Integer>(roadTraffic);
        System.out.println("Roads in sorted order:");
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayBusiestRoad() {
        String busiestRoad = "";
        int maxVehicles = -1;

        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }

        System.out.println("Busiest road: " + busiestRoad + " with " + maxVehicles + " vehicles");
    }

    public void generateTrafficReport() {
        System.out.println("Traffic Report:");
        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            String status;
            if (entry.getValue() >= 1000) {
                status = "Heavy";
            } else if (entry.getValue() >= 500) {
                status = "Moderate";
            } else {
                status = "Light";
            }
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vehicles, Status: " + status);
        }
    }

    public void displayTotalRoads() {
        System.out.println("Total roads monitored: " + roadTraffic.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem system = new SmartCityTrafficMonitoringSystem();

        system.addOrUpdateRoad("MG Road", 850);
        system.addOrUpdateRoad("Airport Road", 1200);
        system.addOrUpdateRoad("Ring Road", 600);
        system.addOrUpdateRoad("Brigade Road", 300);

        system.displaySortedRoads();
        System.out.println();
        system.displayBusiestRoad();
        System.out.println();
        system.generateTrafficReport();
        System.out.println();
        system.displayTotalRoads();
    }
}
