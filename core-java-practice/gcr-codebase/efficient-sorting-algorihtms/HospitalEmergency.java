import java.util.*;

public class HospitalEmergency {
    public static int findKthHighest(int[] priorities, int k) {
        quickSelect(priorities, 0, priorities.length - 1, priorities.length - k);
        return priorities[priorities.length - k];
    }

    private static void quickSelect(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == target) {
                return;
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] priorities = {10, 30, 15, 50, 40};
        int k = 2;
        System.out.println(findKthHighest(priorities, k));
    }
}
