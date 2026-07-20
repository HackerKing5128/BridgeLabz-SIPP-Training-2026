import java.util.*;

public class EmergencyRoomTriageQueue {
    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }

    private PriorityQueue<Patient> triageQueue;

    public EmergencyRoomTriageQueue() {
        triageQueue = new PriorityQueue<Patient>((a, b) -> b.severity - a.severity);
    }

    public boolean addPatient(Patient patient) {
        return triageQueue.offer(patient);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public Patient peekNext() {
        return triageQueue.peek();
    }

    public static void main(String[] args) {
        EmergencyRoomTriageQueue queue = new EmergencyRoomTriageQueue();
        queue.addPatient(new Patient("Asha", 40));
        queue.addPatient(new Patient("Ravi", 90));
        queue.addPatient(new Patient("Neha", 70));

        System.out.println(queue.peekNext().name);
        System.out.println(queue.treatNext().name);
        System.out.println(queue.treatNext().name);
    }
}
