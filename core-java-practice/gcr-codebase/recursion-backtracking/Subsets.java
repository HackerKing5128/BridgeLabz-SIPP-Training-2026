
import java.util.*;

public class Subsets {

    public static List<List<String>> generateSubsets(String[] items) {
        List<List<String>> result = new ArrayList<>();
        backtrack(items, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String[] items, int index,
            List<String> current,
            List<List<String>> result) {

        if (index == items.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include
        current.add(items[index]);
        backtrack(items, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude
        backtrack(items, index + 1, current, result);
    }

    public static void main(String[] args) {

        String[] flags = {"DarkMode", "Checkout", "Search"};

        List<List<String>> subsets = generateSubsets(flags);

        System.out.println("All Feature Flag Combinations:");

        for (List<String> s : subsets) {
            System.out.println(s);
        }
    }
}
