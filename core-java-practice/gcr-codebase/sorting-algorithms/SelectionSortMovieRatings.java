import java.util.*;

public class SelectionSortMovieRatings {
    public static void selectionSort(int[] ratings) {
        for (int i = 0; i < ratings.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ratings.length; j++) {
                if (ratings[j] < ratings[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = ratings[i];
            ratings[i] = ratings[minIndex];
            ratings[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        selectionSort(ratings);
        System.out.println(Arrays.toString(ratings));
    }
}
