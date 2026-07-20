import java.util.PriorityQueue;

class Patient {
    int priority;
    String name;

    public Patient(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }
}

public class Hospital {

    public static void main(String[] args) {

        PriorityQueue<Patient> queue =
                new PriorityQueue<>((a, b) -> a.priority - b.priority);

        queue.offer(new Patient(3, "Rahul"));
        queue.offer(new Patient(1, "Amit"));
        queue.offer(new Patient(2, "Priya"));

        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.name + " (Priority " + p.priority + ")");
        }
    }
}