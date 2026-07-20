import java.util.*;

public class PrintQueue {

    private Deque<Integer> queue = new ArrayDeque<>();

    public void submitJob(int jobId) {
        queue.addLast(jobId);
    }

    public void submitUrgentJob(int jobId) {
        queue.addFirst(jobId);
    }

    public int printNextJob() {
        return queue.removeFirst();
    }

    public static void main(String[] args) {
        PrintQueue printer = new PrintQueue();

        printer.submitJob(1);
        printer.submitJob(2);
        printer.submitUrgentJob(99);

        System.out.println(printer.printNextJob());
        System.out.println(printer.printNextJob());
        System.out.println(printer.printNextJob());
    }
}