abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    abstract double calculateBill();
}

class InPatient extends Patient {
    private double roomCharge;
    private double treatmentCharge;

    public InPatient(int id, String name, int age, double roomCharge, double treatmentCharge) {
        super(id, name, age);
        this.roomCharge = roomCharge;
        this.treatmentCharge = treatmentCharge;
    }

    public double calculateBill() {
        return roomCharge + treatmentCharge;
    }
}

class OutPatient extends Patient {
    private double consultationFee;
    private double treatmentCharge;

    public OutPatient(int id, String name, int age, double consultationFee, double treatmentCharge) {
        super(id, name, age);
        this.consultationFee = consultationFee;
        this.treatmentCharge = treatmentCharge;
    }

    public double calculateBill() {
        return consultationFee + treatmentCharge;
    }
}

public class HospitalPatientManagementSystem {
    public static void main(String[] args) {

        InPatient in = new InPatient(1, "Rahul", 25, 5000, 3000);
        OutPatient out = new OutPatient(2, "Priya", 30, 500, 1500);

        in.displayPatientDetails();
        System.out.println("Bill: " + in.calculateBill() + "\n");

        out.displayPatientDetails();
        System.out.println("Bill: " + out.calculateBill());
    }
}