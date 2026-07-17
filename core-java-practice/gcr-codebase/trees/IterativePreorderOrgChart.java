import java.util.*;

public class IterativePreorderOrgChart {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static List<Integer> iterativePreorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(iterativePreorder(root));
    }
}
