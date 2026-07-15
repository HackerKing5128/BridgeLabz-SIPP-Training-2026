public class ReverseBrowserHistory {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseHistory(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(101);
        head.next = new Node(202);
        head.next.next = new Node(303);
        head.next.next.next = new Node(404);

        head = reverseHistory(head);
        printList(head);
    }
}
