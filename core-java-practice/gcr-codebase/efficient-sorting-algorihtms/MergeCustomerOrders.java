import java.util.*;

public class MergeCustomerOrders {
    public static int[] mergeSortedArrays(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                merged[k++] = first[i++];
            } else {
                merged[k++] = second[j++];
            }
        }

        while (i < first.length) {
            merged[k++] = first[i++];
        }

        while (j < second.length) {
            merged[k++] = second[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] branchA = {1, 4, 8};
        int[] branchB = {2, 5, 7};
        int[] merged = mergeSortedArrays(branchA, branchB);
        System.out.println(Arrays.toString(merged));
    }
}
