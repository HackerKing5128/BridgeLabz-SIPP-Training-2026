import java.util.Arrays;

// Generic Pair class
class Pair<T, U> {
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

// Generic Stack class
class Stack<T> {
    private java.util.ArrayList<T> items;

    public Stack() {
        items = new java.util.ArrayList<T>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (items.isEmpty()) {
            return null;
        }
        return items.remove(items.size() - 1);
    }
}

// Generic Repository class
class Repository<T> {
    private java.util.ArrayList<T> items;

    public Repository() {
        items = new java.util.ArrayList<T>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void displayAll() {
        System.out.println("Repository items:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Main class to demonstrate generic utility classes
public class GenericUtilityDemo {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String, Integer>("Age", 21);

        Stack<String> stack = new Stack<String>();
        stack.push("Java");
        stack.push("Generics");
        stack.push("Collections");

        System.out.println("Pair: " + pair.first + " - " + pair.second);
        System.out.println("\nPopped from stack: " + stack.pop());

        Integer[] numbers = {10, 25, 7, 40, 18};
        System.out.println("\nMaximum number: " + findMax(numbers));

        Repository<String> repository = new Repository<String>();
        repository.add("Item 1");
        repository.add("Item 2");
        repository.add("Item 3");
        repository.displayAll();

        printList(Arrays.asList("A", "B", "C"));
    }

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printList(java.util.List<?> list) {
        System.out.println("\nList items:");
        for (Object item : list) {
            System.out.println(item);
        }
    }
}

