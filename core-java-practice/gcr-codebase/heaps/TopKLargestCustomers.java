import java.util.*;

public class TopKLargestCustomers {
    public static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }

        List<Integer> result = new ArrayList<Integer>(minHeap);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    public static void main(String[] args) {
        int[] transactions = {450, 1200, 300, 900, 2000, 1500};
        System.out.println(topKLargest(transactions, 3));
    }
}
