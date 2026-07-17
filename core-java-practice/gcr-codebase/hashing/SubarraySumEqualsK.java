import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySumEqualsK(int[] revenueChanges, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<Integer, Integer>();
        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {
            runningSum += change;
            answer += prefixCount.getOrDefault(runningSum - k, 0);
            prefixCount.put(runningSum, prefixCount.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] revenueChanges = {2, -2, 3, -3, 4, -4};
        int k = 0;
        System.out.println(subarraySumEqualsK(revenueChanges, k));
    }
}
