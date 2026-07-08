import java.util.*;

public class MergeSortEmployeeSalaries {
    public static void mergeSort(int[] salaries, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(salaries, left, mid, temp);
            mergeSort(salaries, mid + 1, right, temp);
            merge(salaries, left, mid, right, temp);
        }
    }

    private static void merge(int[] salaries, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (salaries[i] <= salaries[j]) {
                temp[k++] = salaries[i++];
            } else {
                temp[k++] = salaries[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = salaries[i++];
        }

        while (j <= right) {
            temp[k++] = salaries[j++];
        }

        for (int index = left; index <= right; index++) {
            salaries[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] salaries = {45000, 32000, 78000, 55000, 40000, 60000};
        mergeSort(salaries, 0, salaries.length - 1, new int[salaries.length]);
        System.out.println(Arrays.toString(salaries));
    }
}
