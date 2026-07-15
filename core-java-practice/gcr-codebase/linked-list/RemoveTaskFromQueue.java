public class RemoveTaskFromQueue {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node removeTask(Node head, int taskId) {
        if (head == null) {
            return null;
        }

        if (head.val == taskId) {
            return head.next;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null && current.val != taskId) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }

        return head;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = removeTask(head, 3);
        printList(head);
    }
}
