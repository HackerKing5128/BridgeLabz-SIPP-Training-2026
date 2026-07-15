import java.util.*;

public class UndoBufferStack {
    private String[] data;
    private int top;

    public UndoBufferStack(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    public boolean push(String edit) {
        if (top == data.length - 1) {
            return false;
        }

        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }

        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }

        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UndoBufferStack stack = new UndoBufferStack(3);
        System.out.println(stack.push("Type A"));
        System.out.println(stack.push("Type B"));
        System.out.println(stack.push("Type C"));
        System.out.println(stack.push("Type D"));
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
