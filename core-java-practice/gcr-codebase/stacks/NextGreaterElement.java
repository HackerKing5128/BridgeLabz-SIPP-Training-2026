import java.util.*;

public class NextGreaterElement {
    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] visitors = {30, 40, 35, 50, 45};
        System.out.println("Visitors: " + Arrays.toString(visitors));
        System.out.println(Arrays.toString(nextBusierDay(visitors)));
    }
}
