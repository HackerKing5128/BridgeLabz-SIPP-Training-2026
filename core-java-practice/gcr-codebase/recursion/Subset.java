// generate all subsets of an array recursively

import java.util.Arrays;

class Subset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output:");
        generateSubsets(arr, 0, new int[0]);
    }

    private static void generateSubsets(int[] arr, int index, int[] current) {
        if (index == arr.length) {
            System.out.println(Arrays.toString(current));
            return;
        }
        // Include the current element
        int[] newCurrent = Arrays.copyOf(current, current.length + 1);
        newCurrent[newCurrent.length - 1] = arr[index];
        generateSubsets(arr, index + 1, newCurrent);
        // Exclude the current element
        generateSubsets(arr, index + 1, current);
    }
    
}
