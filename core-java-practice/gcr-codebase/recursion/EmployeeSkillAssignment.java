// Employee Skill Assignment using recursion

import java.util.*;

class EmployeeSkillAssignment {
    public static void main(String[] args) {
        int[] skillScores = {2, 3, 5, 7};
        int target = 10;

        System.out.println("Employee Skill Scores: " + Arrays.toString(skillScores));
        System.out.println("Target: " + target);
        System.out.println("Possible Project Teams:");
        findTeams(skillScores, target);
    }

    public static void findTeams(int[] skillScores, int target) {
        // call recursive helper function
        solve(skillScores, target, new ArrayList<>(), 0);
    }

    private static void solve(int[] skillScores, int target, List<Integer> result, int index) {
        if (target == 0) {
            System.out.println(result);
            return;
        }
        if (index == skillScores.length || target < 0) {
            return;
        }
        // Include the current skill score
        result.add(skillScores[index]);
        solve(skillScores, target - skillScores[index], result, index + 1);

        // Backtrack and exclude the current skill score
        result.remove(result.size() - 1);
        solve(skillScores, target, result, index + 1);
    }
}