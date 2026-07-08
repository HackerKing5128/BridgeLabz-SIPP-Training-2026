import java.util.*;

public class WebsiteResponseAnalysis {
    public static long countViolations(int[] times) {
        return mergeSortAndCount(times, 0, times.length - 1, new int[times.length]);
    }

    private static long mergeSortAndCount(int[] times, int left, int right, int[] temp) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            count = count + mergeSortAndCount(times, left, mid, temp);
            count = count + mergeSortAndCount(times, mid + 1, right, temp);
            count = count + mergeAndCount(times, left, mid, right, temp);
        }

        return count;
    }

    private static long mergeAndCount(int[] times, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (times[i] <= times[j]) {
                count = count + (right - j + 1);
                temp[k++] = times[i++];
            } else {
                temp[k++] = times[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = times[i++];
        }

        while (j <= right) {
            temp[k++] = times[j++];
        }

        for (int index = left; index <= right; index++) {
            times[index] = temp[index];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] times = {300, 250, 270, 100};
        System.out.println(countViolations(times));
    }
}
