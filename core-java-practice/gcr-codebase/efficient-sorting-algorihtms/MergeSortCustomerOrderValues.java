import java.util.*;

public class MergeSortCustomerOrderValues {
    public static void mergeSort(int[] values, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(values, left, mid, temp);
            mergeSort(values, mid + 1, right, temp);
            merge(values, left, mid, right, temp);
        }
    }

    private static void merge(int[] values, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (values[i] <= values[j]) {
                temp[k++] = values[i++];
            } else {
                temp[k++] = values[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = values[i++];
        }

        while (j <= right) {
            temp[k++] = values[j++];
        }

        for (int index = left; index <= right; index++) {
            values[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] values = {850, 420, 1200, 650, 300};
        mergeSort(values, 0, values.length - 1, new int[values.length]);
        System.out.println(Arrays.toString(values));
    }
}
