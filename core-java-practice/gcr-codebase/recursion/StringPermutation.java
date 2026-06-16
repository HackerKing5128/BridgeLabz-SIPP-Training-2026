// print all the permutations of a given string using recursion.

class StringPermutation {
    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Input: " + input);
        System.out.println("Output:");
        generatePermutations(input);
    }

    public static void generatePermutations(String str) {
        // call recursive helper function
        solve(str, "");
    }

    public static void solve(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String res = str.substring(0, i) + str.substring(i + 1);
            solve(res, ans + ch);
        }
    }
}
