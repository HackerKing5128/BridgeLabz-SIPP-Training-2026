import java.util.*;

public class BalancedBracketsValidator {
    public static boolean isValidConfig(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> matchFor = new HashMap<Character, Character>();
        matchFor.put(')', '(');
        matchFor.put(']', '[');
        matchFor.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "{[()]}";
        String s2 = "{[(])}";

        System.out.println(s1 + " -> " + isValidConfig(s1));
        System.out.println(s2 + " -> " + isValidConfig(s2));
    }
}
