
import java.util.*;

public class Permutations {

    public static List<List<String>> generatePermutations(String[] people) {

        List<List<String>> result = new ArrayList<>();

        boolean[] used = new boolean[people.length];

        backtrack(people,
                used,
                new ArrayList<>(),
                result);

        return result;
    }

    private static void backtrack(String[] people,
            boolean[] used,
            List<String> path,
            List<List<String>> result) {

        if (path.size() == people.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < people.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;

            path.add(people[i]);

            backtrack(people,
                    used,
                    path,
                    result);

            path.remove(path.size() - 1);

            used[i] = false;
        }
    }

    public static void main(String[] args) {

        String[] engineers = {
            "Nayan",
            "Raghav",
            "Yash",
            "Nakul"
        };

        List<List<String>> schedules = generatePermutations(engineers);

        System.out.println("Possible Schedules:");

        for (List<String> schedule : schedules) {
            System.out.println(schedule);
        }
    }
}
