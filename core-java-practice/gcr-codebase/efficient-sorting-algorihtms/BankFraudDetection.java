import java.util.*;

public class BankFraudDetection {
    public static long countSuspiciousPairs(int[] amounts) {
        return mergeSortAndCount(amounts, 0, amounts.length - 1, new int[amounts.length]);
    }

    private static long mergeSortAndCount(int[] amounts, int left, int right, int[] temp) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            count = count + mergeSortAndCount(amounts, left, mid, temp);
            count = count + mergeSortAndCount(amounts, mid + 1, right, temp);
            count = count + countPairs(amounts, left, mid, right);
            merge(amounts, left, mid, right, temp);
        }

        return count;
    }

    private static long countPairs(int[] amounts, int left, int mid, int right) {
        long count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) amounts[i] > 3L * amounts[j]) {
                j++;
            }
            count = count + (j - (mid + 1));
        }

        return count;
    }

    private static void merge(int[] amounts, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (amounts[i] <= amounts[j]) {
                temp[k++] = amounts[i++];
            } else {
                temp[k++] = amounts[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = amounts[i++];
        }

        while (j <= right) {
            temp[k++] = amounts[j++];
        }

        for (int index = left; index <= right; index++) {
            amounts[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] amounts = {12, 4, 5, 2};
        System.out.println(countSuspiciousPairs(amounts));
    }
}
