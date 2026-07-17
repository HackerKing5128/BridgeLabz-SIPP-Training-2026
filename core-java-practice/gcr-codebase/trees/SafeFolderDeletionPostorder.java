import java.util.*;

public class SafeFolderDeletionPostorder {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void deleteFolderTree(Node node) {
        if (node == null) {
            return;
        }

        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        System.out.println("Deleted folder: " + node.val);
    }

    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(200);
        root.right = new Node(300);
        root.left.left = new Node(400);
        root.left.right = new Node(500);

        deleteFolderTree(root);
    }
}
