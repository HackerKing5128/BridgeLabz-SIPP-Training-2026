import java.util.*;

public class EmployeePromotionConflicts {
    public static long countConflicts(int[] scores) {
        return mergeSortAndCount(scores, 0, scores.length - 1, new int[scores.length]);
    }

    private static long mergeSortAndCount(int[] scores, int left, int right, int[] temp) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            count = count + mergeSortAndCount(scores, left, mid, temp);
            count = count + mergeSortAndCount(scores, mid + 1, right, temp);
            count = count + mergeAndCount(scores, left, mid, right, temp);
        }

        return count;
    }

    private static long mergeAndCount(int[] scores, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (scores[i] < scores[j]) {
                count = count + (mid - i + 1);
                temp[k++] = scores[j++];
            } else {
                temp[k++] = scores[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = scores[i++];
        }

        while (j <= right) {
            temp[k++] = scores[j++];
        }

        for (int index = left; index <= right; index++) {
            scores[index] = temp[index];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] scores = {70, 95, 80, 100};
        System.out.println(countConflicts(scores));
    }
}
