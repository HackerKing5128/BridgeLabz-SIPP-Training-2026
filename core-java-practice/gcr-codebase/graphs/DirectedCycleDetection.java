
import java.util.*;

public class DirectedCycleDetection {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int from, int to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    private boolean dfs(int node, int[] state) {

        state[node] = 1; // GRAY

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {

            if (state[neighbor] == 1) {
                return true;
            }

            if (state[neighbor] == 0) {

                if (dfs(neighbor, state)) {
                    return true;
                }
            }
        }

        state[node] = 2; // BLACK

        return false;
    }

    public boolean hasCycle(int vertices) {

        int[] state = new int[vertices];

        for (int i = 0; i < vertices; i++) {

            if (state[i] == 0) {

                if (dfs(i, state)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        DirectedCycleDetection graph = new DirectedCycleDetection();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        if (graph.hasCycle(4)) {
            System.out.println("Cycle Found"); 
        }else {
            System.out.println("No Cycle");
        }
    }
}
