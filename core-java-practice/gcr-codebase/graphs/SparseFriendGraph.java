
import java.util.*;

public class SparseFriendGraph {

    private Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    // Add friendship
    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    // Check friendship
    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    // Display graph
    public void displayGraph() {
        for (int user : friendGraph.keySet()) {
            System.out.println(user + " -> " + friendGraph.get(user));
        }
    }

    public static void main(String[] args) {

        SparseFriendGraph graph = new SparseFriendGraph();

        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(2, 4);
        graph.addFriendship(3, 5);

        graph.displayGraph();

        System.out.println("\nIs 1 friend with 2? " + graph.isFriend(1, 2));
        System.out.println("Is 2 friend with 5? " + graph.isFriend(2, 5));
    }
}
