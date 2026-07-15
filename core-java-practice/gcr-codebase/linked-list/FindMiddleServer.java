public class FindMiddleServer {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(11);
        head.next = new Node(22);
        head.next.next = new Node(33);
        head.next.next.next = new Node(44);
        head.next.next.next.next = new Node(55);

        Node middle = findMiddleServer(head);
        System.out.println(middle.val);
    }
}
