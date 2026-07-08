import java.util.*;

public class QuickSortFlightTicketPrices {
    public static void quickSort(int[] prices, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(prices, left, right);
            quickSort(prices, left, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] prices, int left, int right) {
        int pivot = prices[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (prices[j] <= pivot) {
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
                i++;
            }
        }

        int temp = prices[i];
        prices[i] = prices[right];
        prices[right] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] prices = {4500, 2200, 3800, 1800, 5200};
        quickSort(prices, 0, prices.length - 1);
        System.out.println(Arrays.toString(prices));
    }
}
