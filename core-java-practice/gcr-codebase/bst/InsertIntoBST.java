import java.util.*;

public class InsertIntoBST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }

        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }

        return node;
    }

    public static void inorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        root = insert(root, 40);
        root = insert(root, 60);

        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        System.out.println(result);
    }
}
