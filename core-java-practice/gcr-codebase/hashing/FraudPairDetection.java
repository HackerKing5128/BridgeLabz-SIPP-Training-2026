import java.util.*;

public class FraudPairDetection {
    public static int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();

        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];

            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            }

            seen.put(amounts[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] amounts = {12000, 18000, 5000, 30000, 20000};
        int target = 50000;
        System.out.println(Arrays.toString(findFraudPair(amounts, target)));
    }
}
