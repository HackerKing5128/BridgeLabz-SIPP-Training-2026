import java.util.*;

public class SlidingWindow {

    public static int[] maxWindow(int[] arr, int k) {

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] readings = {10, 5, 2, 7, 8, 7};
        int k = 3;

        int[] ans = maxWindow(readings, k);

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}