import java.util.*;

public class BubbleSortProductPrices {
    public static void bubbleSort(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 0; j < prices.length - 1 - i; j++) {
                if (prices[j] > prices[j + 1]) {
                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        bubbleSort(prices);
        System.out.println(Arrays.toString(prices));
    }
}
