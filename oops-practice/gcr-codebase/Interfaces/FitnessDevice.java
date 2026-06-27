// trackable interface
interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Trackable data reset");
    }
}

// reportable interface
interface Reportable {
    void generateReport();
}

// notifiable interface
interface Notifiable {
    void sendAlert();
}

public class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String deviceName;
    private int stepCount;

    public FitnessDevice() {
        deviceName = "Fitness Band";
        stepCount = 0;
    }

    public void logActivity() {
        stepCount = stepCount + 1200;
        System.out.println(deviceName + " logged activity. Steps: " + stepCount);
    }

    public void generateReport() {
        System.out.println("Activity report generated for " + deviceName + ". Steps: " + stepCount);
    }

    public void sendAlert() {
        System.out.println("Alert sent from " + deviceName + ": Time to move");
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity();
        device.generateReport();
        device.sendAlert();

        Trackable trackable = device;
        trackable.resetData();
    }
}
