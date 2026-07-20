import java.util.*;

public class FindKthLargestScore {
    public static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] scores = {81, 92, 75, 88, 97, 84};
        System.out.println(findKthLargest(scores, 2));
    }
}
