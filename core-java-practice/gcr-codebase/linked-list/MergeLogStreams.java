public class MergeLogStreams {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;
        return dummy.next;
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
        Node a = new Node(1);
        a.next = new Node(4);
        a.next.next = new Node(7);

        Node b = new Node(2);
        b.next = new Node(3);
        b.next.next = new Node(6);

        Node merged = mergeLogStreams(a, b);
        printList(merged);
    }
}
