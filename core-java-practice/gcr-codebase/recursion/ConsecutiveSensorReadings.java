// Is Strictly Increasing using recursion

import java.util.Arrays;

class ConsecutiveSensorReadings {
    public static void main(String[] args) {
        int[] arr1 = {12, 15, 18, 22, 30};
        int[] arr2 = {12, 15, 14, 22};

        System.out.println(Arrays.toString(arr1));
        System.out.println("is Strictly Increasing: " + isStrictlyIncreasing(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println("is Strictly Increasing: " + isStrictlyIncreasing(arr2));
    }

    public static boolean isStrictlyIncreasing(int[] arr) {
        // call recursive helper function
        return solve(arr, 0);
    }

    private static boolean solve(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] >= arr[index + 1]) {
            return false;
        }
        return solve(arr, index + 1);
    }
}