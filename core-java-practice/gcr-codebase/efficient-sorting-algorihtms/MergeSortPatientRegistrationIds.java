import java.util.*;

public class MergeSortPatientRegistrationIds {
    public static void mergeSort(int[] ids, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(ids, left, mid, temp);
            mergeSort(ids, mid + 1, right, temp);
            merge(ids, left, mid, right, temp);
        }
    }

    private static void merge(int[] ids, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (ids[i] <= ids[j]) {
                temp[k++] = ids[i++];
            } else {
                temp[k++] = ids[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = ids[i++];
        }

        while (j <= right) {
            temp[k++] = ids[j++];
        }

        for (int index = left; index <= right; index++) {
            ids[index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] ids = {105, 101, 108, 102, 104};
        mergeSort(ids, 0, ids.length - 1, new int[ids.length]);
        System.out.println(Arrays.toString(ids));
    }
}
